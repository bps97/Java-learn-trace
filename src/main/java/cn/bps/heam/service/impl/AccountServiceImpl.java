package cn.bps.heam.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.common.lang.util.EncryptUtils;
import cn.bps.heam.domain.form.UserForm;
import cn.bps.heam.domain.model.Account;
import cn.bps.heam.domain.model.AccountExample;
import cn.bps.heam.mapper.AccountMapper;
import cn.bps.heam.service.AccountService;
import cn.bps.security.server.service.TokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private TokenService tokenService;

    @Override
    public void userRegister(UserForm userForm) {
        if(!checkUsername(userForm)){
            // 这里需要写一个注册失败相关的返回对象  划掉 不写了 下面抛异常
            throw new LocalBizServiceException(CustomizeExceptionCode.NAME_ALREADY_EXIST, userForm.getUsername());
        } else {
            Account account = new Account();
            String md5Password = EncryptUtils.md5Encrypt(userForm.getPassword()); // 加密密码
            account.setUsername(userForm.getUsername());
            account.setPassword(md5Password);
        }
    }

    @Override
    public void login(UserForm userForm) {
        String username = userForm.getUsername();
        String password = userForm.getPassword();
        Account account = getAccountByUsername(username);
        if(Objects.isNull(account)) {  /*如果该账户不存在*/
            throw new LocalBizServiceException(CustomizeExceptionCode.ACCOUNT_NOT_EXIST, userForm.getUsername());
        }else{
            String md5Password = EncryptUtils.md5Encrypt(password);
            if(Objects.equals(md5Password, account.getPassword())) {
                return;
            }else { /*密码错误*/
                throw new LocalBizServiceException(CustomizeExceptionCode.PASSWORD_NOT_INCORRECT, userForm.getUsername());
            }
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
        return Objects.nonNull(list) && list.isEmpty() == false ? list.get(0) : null;
    }
}
