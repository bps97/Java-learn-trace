package cn.bps.heam.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.heam.domain.form.UserForm;
import cn.bps.heam.domain.model.Account;
import cn.bps.heam.domain.model.AccountExample;
import cn.bps.common.lang.domain.Success;
import cn.bps.heam.mapper.AccountMapper;
import cn.bps.heam.service.AccountService;
import cn.bps.common.lang.util.Generator;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void userRegister(UserForm userForm) {
        if(!checkUsername(userForm)){
            // 这里需要写一个注册失败相关的返回对象
            throw new LocalBizServiceException(CustomizeExceptionCode.NAME_ALREADY_EXIST, userForm.getUsername());
        } else {
            Account account = new Account();
            String md5Password = DigestUtils.md5DigestAsHex(userForm.getPassword().getBytes());// 加密密码
            account.setUsername(userForm.getUsername());
            account.setPassword(md5Password);
            accountMapper.insert(account);
        }
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
