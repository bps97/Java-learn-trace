package cn.bps.mms.service;

import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.AppForm;
import cn.bps.mms.enums.AppFormType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 申请单 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
public interface AppFormService extends IService<AppForm> {

    AppForm getApplication(Account account);

    AppForm getApplication(Account account, AppFormType type);

    AppForm getApplication(String tokenValue);

    AppForm getApplication(String tokenValue, AppFormType type);

    void addMessage(AppForm applicationForm, String token);

}
