package cn.bps.heam.controller;

import cn.bps.common.lang.annotation.Label;
import cn.bps.common.lang.domain.Ret;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.form.UserForm;
import cn.bps.heam.domain.form.UserInfoForm;
import cn.bps.heam.domain.result.UserInfoResult;
import cn.bps.heam.domain.result.UserResult;
import cn.bps.heam.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Label("用户模块")
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private AccountService accountService;

    /**
     * @param userForm 用户表单
     * @return
     * @Label("用户注册")
     */
    @PostMapping("/reg")
    public Ret userRegister(UserForm userForm) {
        return Ret.ok(() -> accountService.userRegister(userForm));
    }

    @Label("修改用户密码")
    public Ret changePassword(UserForm userForm) {
        return Ret.ok();
    }

    @Label("用戶身份检查") /*用于登录*/
    public Ret checkUser(UserForm userForm) {
        return Ret.ok();
    }

    @Label("登录")
    @PostMapping("/login")
    public Ret login(@RequestBody UserForm loginForm) {
        return Ret.ok(() -> accountService.login(loginForm));
    }

    @GetMapping("")
    public Ret pageUsers(PageRequest pageRequest, String key){
        return Ret.ok(accountService.pageUsers(pageRequest, key));
    }

    @Label("添加指定")
    @PutMapping("/{id}/available/{available}")
    public Ret changeAccountAvailability(@PathVariable String id,@PathVariable Boolean available){
        return Ret.ok(accountService.changeAvailable(id,available));
    }
    @Label("获取指定用户信息")
    @GetMapping("/{id}")
    public Ret<UserResult> getUserInfo(@PathVariable String id) {
        return Ret.ok(()->accountService.getUserById(id));
    }

    @Label("修改用戶信息")
    @DeleteMapping("/{id}")
    public Ret deleteUser(@PathVariable String id) {
        return Ret.ok(()->accountService.deleteAccount(id));
    }

    @Label("修改用戶信息")
    public Ret<UserInfoResult> modifyUserInfo(UserInfoForm userInfoForm) {
        return Ret.ok();
    }


    /**
     * 以下接口暂不编写
     */

    @Label("重置密码")
    public void resetPassword(UserForm userForm) {
    }

    @Label("忘记密码")
    public void forgetPassword() {
    }

    @Label("实名认证")
    public void realNameCertification() {

    }


}
