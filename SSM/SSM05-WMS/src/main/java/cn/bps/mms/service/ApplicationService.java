package cn.bps.mms.service;

import cn.bps.mms.model.ao.ApplicationAo;
import cn.bps.mms.model.pojo.Account;
import cn.bps.mms.model.pojo.Application;
import cn.bps.mms.model.enums.ApplicationType;
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

    Application getUserApplication(Account account);

    Application getUserApplication(Account account, ApplicationType type);

    Application getUserApplication(String tokenValue);

    Application getUserApplication(String tokenValue, ApplicationType type);

    void addMessage(ApplicationAo ao, String token);

}
