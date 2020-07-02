package cn.bps.mms.service;

import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.ApplicationForm;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 申请单 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
public interface ApplicationFormService extends IService<ApplicationForm> {

    ApplicationForm getApplication(Account account);

    ApplicationForm getApplication(String tokenValue);

    void addMessage(ApplicationForm applicationForm, String token);

}
