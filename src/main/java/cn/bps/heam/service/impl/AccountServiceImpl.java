package cn.bps.heam.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.api.Token;
import cn.bps.common.lang.util.EncryptUtils;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.form.UserForm;
import cn.bps.heam.domain.model.Account;
import cn.bps.heam.domain.model.AccountExample;
import cn.bps.heam.domain.result.UserResult;
import cn.bps.heam.mapper.AccountMapper;
import cn.bps.heam.service.AccountService;
import cn.bps.heam.service.ResourceUriService;
import cn.bps.security.server.service.TokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private TokenService tokenService;

    @Resource
    private ResourceUriService resourceUriService;

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
    public Token login(UserForm userForm) {
        String username = userForm.getUsername();
        String password = userForm.getPassword();
        Account account = getAccountByUsername(username);
        if(Objects.isNull(account)) {  /*如果该账户不存在*/
            throw new LocalBizServiceException(CustomizeExceptionCode.ACCOUNT_NOT_EXIST, userForm.getUsername());
        }else{
            String md5Password = EncryptUtils.md5Encrypt(password);
            if(Objects.equals(md5Password, account.getPassword())) {
                Token xx = tokenService.getAccessTokenByUser(username);
                return xx;
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

    @Override
    public UserResult getUserById(String id) {
        return model2Result(getAccountById(id));
    }

    @Override
    public Account getAccountById(String id) {
        return accountMapper.selectByPrimaryKey(id);
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
    public List<UserResult> listUsers(PageRequest pageRequest, String key) {
        AccountExample accountExample = new AccountExample();
        if(Objects.equals(key,"") == false){
            accountExample.or().andNicknameLike("%" + key + "%")
                    .andUserEmailLike("%" + key + "%");
        }
        List<Account> accountList = accountMapper.selectByExampleWithRowbounds(accountExample, pageRequest.rowBounds());
        return accountList.stream().map(this::model2Result).collect(Collectors.toList());
    }

    public UserResult model2Result(Account account) {
        UserResult result = new UserResult();
        result.setId(account.getId());
        result.setMobile(account.getCellphoneNum());
        result.setNickname(account.getNickname());
        result.setSex(account.getUserSex());
        result.setEmail(account.getUserEmail());
        result.setUsername(account.getUsername());
        result.setAvailable(account.getAvailable());
        String avatar = resourceUriService.getUri(account.getAvatar());
        result.setAvatar(avatar);
        return result;
    }

    @Override
    public Page<UserResult> pageUsers(PageRequest pageRequest, String key) {
        List<UserResult> content = listUsers(pageRequest, key);
        Page page = new Page(content);
        page.setTotalElements(content.size());
        page.setSize(pageRequest.getSize());
        page.setPage(pageRequest.getPage());

        return page;
    }

    @Override
    public UserResult changeAvailable(String id, boolean available) {
        Account account = new Account();
        account.setAvailable(available);
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andIdEqualTo(id);
        int res = accountMapper.updateByExampleSelective(account, accountExample);
        if(res != 1){
            throw new LocalBizServiceException(CustomizeExceptionCode.UPDATE_FAIL);
        }
        account = accountMapper.selectByPrimaryKey(id);
        return model2Result(account);
    }
}
