package cn.bps.heam.service.impl;

import cn.bps.heam.domain.form.UserForm;
import cn.bps.heam.domain.model.Account;
import cn.bps.heam.domain.model.AccountExample;
import cn.bps.heam.mapper.AccountMapper;
import cn.bps.heam.service.AccountService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void userRegister(UserForm userForm) {
        // 这里需要写一个注册成功失败相关的返回对象
    }

    @Override
    public boolean checkUsername(UserForm userForm) {
        Account account = getAccountByUsername(userForm.getUsername());
        return Objects.nonNull(account);
    }

    @Override
    public Account getAccountByUsername(String username) {
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andUsernameEqualTo(username);
        List<Account> list = accountMapper.selectByExample(accountExample);
        return Objects.nonNull(list) ? list.get(0) : null;
    }
}
