package cn.bps.heam.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.Account;
import cn.bps.heam.domain.model.template.AccountExample;
import cn.bps.heam.mapper.AccountMapper;
import cn.bps.heam.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;


    @Override
    public Account getAccountById(String id) {
        return accountMapper.selectByPrimaryKey(id);
    }


    @Override
    public Account getAccountByUsername(String username) {
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andUsernameEqualTo(username);
        List<Account> list = accountMapper.selectByExample(accountExample);
        return Objects.nonNull(list) && list.isEmpty() == false ? list.get(0) : null;
    }

    @Override
    public void deleteAccount(String id) {
        int res = accountMapper.deleteByPrimaryKey(id);
        if(res != 1){
            throw new LocalBizServiceException(CustomizeExceptionCode.DELETE_FAIL);
        }
        return;
    }

    @Override
    public void updateAccount(Account account) {
        accountMapper.updateByPrimaryKeySelective(account);
    }

    @Override
    public List<Account> listUsers(PageRequest pageRequest, String key) {
        AccountExample accountExample = new AccountExample();
        if(Objects.equals(key,"") == false){
            accountExample.or().andNicknameLike("%" + key + "%")
                    .andUserEmailLike("%" + key + "%");
        }
        List<Account> accountList = accountMapper.selectByExampleWithRowbounds(accountExample, pageRequest.rowBounds());
        return accountList;
    }

    @Override
    public Account changeAvailable(String id, boolean available) {
        Account account = new Account();
        account.setAvailable(available);
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andIdEqualTo(id);
        int res = accountMapper.updateByExampleSelective(account, accountExample);
        if(res != 1){
            throw new LocalBizServiceException(CustomizeExceptionCode.UPDATE_FAIL);
        }
        account = accountMapper.selectByPrimaryKey(id);
        return account;
    }



}
