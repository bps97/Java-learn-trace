package cn.bps.mms.service;

import cn.bps.mms.domain.ao.ApplicationAo;
import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.Application;
import cn.bps.mms.domain.ApplicationType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 申请单 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
public interface ApplicationService extends IService<Application> {

    Application getApplication(Account account);

    Application getApplication(Account account, ApplicationType type);

    Application getApplication(String tokenValue);

    Application getApplication(String tokenValue, ApplicationType type);

    void addMessage(ApplicationAo ao, String token);

}
