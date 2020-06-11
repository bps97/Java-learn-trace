package cn.bps.mms.service;

import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.api.Token;
import cn.bps.common.lang.domain.Callback;
import cn.bps.mms.domain.PageRequest;
import cn.bps.mms.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 账户基本信息 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
public interface AccountService extends IService<Account> {

    Token login(Account loginForm);

    void register(Account regForm);

    Account getByUsername(String username);

    Page<Account> pageUsers(PageRequest pageRequest, String key);

    void changeAvailable(String id, Boolean available);

    void updateById(String id, Account account);
}
