package cn.bps.mms.service.impl;

import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.Application;
import cn.bps.mms.mapper.ApplicationMapper;
import cn.bps.mms.service.ApplicationItemService;
import cn.bps.mms.service.ApplicationService;
import cn.bps.mms.service.RecordService;
import cn.bps.security.server.service.TokenService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 账户基本信息 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

    @Resource
    private TokenService tokenService;

    @Resource
    private ApplicationItemService applicationItemService;

    @Resource
    private RecordService recordService;

    @Override
    public Application getApplication(Account account) {
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("user_id", account.getId());
        List<Application> applications = this.list(wrapper);
        Application application = null;
        if(applications.isEmpty()){
            application = new Application();
            application.setUserId(account.getId());
            application.setUserName(account.getName());
        }else {
            application = applications.get(0);
        }
        return application;
    }

    @Override
    public Application getApplication(String tokenValue) {
        Account account = tokenService.getAccount(tokenValue);
        return getApplication(account);
    }

    @Override
    public void addMessage(Application application, String tokenValue) {
        Application myApplication = getApplication(tokenValue);
        myApplication.setMessage(application.getMessage());
        this.updateById(myApplication);

        // 清空清单项
        applicationItemService.closeItems(myApplication);

        // 记录信息


    }
}
