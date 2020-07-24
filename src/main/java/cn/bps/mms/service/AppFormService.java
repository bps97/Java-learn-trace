package cn.bps.mms.service;

import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.AppForm;
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

    AppForm getApplication(String tokenValue);

    void addMessage(AppForm applicationForm, String token);

}
