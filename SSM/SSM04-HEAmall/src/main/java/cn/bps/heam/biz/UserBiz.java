package cn.bps.heam.biz;

import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.api.Token;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.form.UserForm;
import cn.bps.heam.domain.form.UserInfoForm;
import cn.bps.heam.domain.result.UserResult;

import java.util.List;

public interface UserBiz {

    List<UserResult> listUsers(PageRequest pageRequest, String key);

    Page<UserResult> pageUsers(PageRequest pageRequest, String key);

    UserResult changeAvailable(String id, boolean available);

    UserResult getUserById(String id);

    void userRegister(UserForm userForm);

    void updateUserInfo(String id, UserInfoForm userInfoForm);

    Token login(UserForm userForm);

    boolean checkUsername(UserForm userForm);

}
