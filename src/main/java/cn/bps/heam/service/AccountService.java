package cn.bps.heam.service;

import cn.bps.heam.domain.form.UserForm;
import cn.bps.heam.domain.model.Account;

public interface AccountService {

    void userRegister(UserForm userForm);

    boolean checkUsername(UserForm userForm);

    Account getAccountByUsername(String username);

}
