package cn.bps.heam.biz.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.api.Token;
import cn.bps.common.lang.util.EncryptUtils;
import cn.bps.heam.biz.UserBiz;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.form.UserForm;
import cn.bps.heam.domain.form.UserInfoForm;
import cn.bps.heam.domain.model.Account;
import cn.bps.heam.domain.result.UserResult;
import cn.bps.heam.service.AccountService;
import cn.bps.heam.service.ResourceUriService;
import cn.bps.security.server.service.TokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserBizImpl implements UserBiz {

    @Resource
    private AccountService accountService;

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
    public void updateUserInfo(String id, UserInfoForm userInfoForm) {
        Account account = new Account();
        account.setUserEmail(userInfoForm.getEmail());
        account.setCellphoneNum(userInfoForm.getMobile());
        account.setId(id);

        accountService.update(account);
    }

    @Override
    public Token login(UserForm userForm) {
        String username = userForm.getUsername();
        String password = userForm.getPassword();
        Account account = accountService.getAccountByUsername(username);
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
        Account account = accountService.getAccountByUsername(userForm.getUsername());
        return Objects.nonNull(account);
    }

    @Override
    public UserResult getUserById(String id) {
        return model2Result(accountService.getAccountById(id));
    }


    @Override
    public List<UserResult> listUsers(PageRequest pageRequest, String key) {
        List<Account> accountList = accountService.listUsers(pageRequest,key);
        return accountList.stream().map(this::model2Result).collect(Collectors.toList());
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
        Account account = accountService.changeAvailable(id, available);
        return model2Result(account);
    }

    private UserResult model2Result(Account account) {
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


}
