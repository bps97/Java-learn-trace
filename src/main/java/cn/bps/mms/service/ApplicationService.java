package cn.bps.mms.service;

import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.Application;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 账户基本信息 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
public interface ApplicationService extends IService<Application> {

    Application getApplication(Account account);

    Application getApplication(String tokenValue);

    void addMessage(Application application, String token);


}
