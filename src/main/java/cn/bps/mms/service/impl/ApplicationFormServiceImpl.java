package cn.bps.mms.service.impl;

import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.ApplicationForm;
import cn.bps.mms.mapper.ApplicationFormMapper;
import cn.bps.mms.service.ApplicationFormItemService;
import cn.bps.mms.service.ApplicationFormService;
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
public class ApplicationFormServiceImpl extends ServiceImpl<ApplicationFormMapper, ApplicationForm> implements ApplicationFormService {

    @Resource
    private TokenService tokenService;

    @Resource
    private ApplicationFormItemService applicationFormItemService;

    @Resource
    private RecordService recordService;

    @Override
    public ApplicationForm getApplication(Account account) {
        QueryWrapper<ApplicationForm> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("user_id", account.getId());
        List<ApplicationForm> applicationForms = this.list(wrapper);
        ApplicationForm applicationForm = null;
        if(applicationForms.isEmpty()){
            applicationForm = new ApplicationForm();
            applicationForm.setUserId(account.getId());
            applicationForm.setUserName(account.getName());
            this.save(applicationForm);
        }else {
            applicationForm = applicationForms.get(0);
        }
        return applicationForm;
    }

    @Override
    public ApplicationForm getApplication(String tokenValue) {
        Account account = tokenService.getAccount(tokenValue);
        return getApplication(account);
    }

    @Override
    public void addMessage(ApplicationForm applicationForm, String tokenValue) {
        ApplicationForm myApplicationForm = getApplication(tokenValue);
        myApplicationForm.setMessage(applicationForm.getMessage());
        myApplicationForm.setType("领用");

        // 清空清单项
        applicationFormItemService.closeItems(myApplicationForm);

        // 记录信息
        recordService.record(myApplicationForm);

        // 关闭清单
        myApplicationForm.setAvailable(false);
        this.updateById(myApplicationForm);

    }
}
