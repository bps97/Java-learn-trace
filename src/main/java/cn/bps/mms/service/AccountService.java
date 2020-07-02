package cn.bps.mms.service;

import cn.bps.common.lang.api.Token;
import cn.bps.common.lang.domain.Callback;
import cn.bps.mms.domain.PageRequest;
import cn.bps.mms.domain.vo.AccountVo;
import cn.bps.mms.entity.Account;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    IPage<AccountVo> pageUsers(Page<Account> page, String key);

    void changeAvailable(String id, Boolean available);

    void updateById(String id, Account account);

    void changeRoleId(String id, String roleId);
}
