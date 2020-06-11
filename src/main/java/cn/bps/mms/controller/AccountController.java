package cn.bps.mms.controller;


import cn.bps.common.lang.annotation.Label;
import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.api.Token;
import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.domain.PageRequest;
import cn.bps.mms.entity.Account;
import cn.bps.mms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 账户基本信息 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/login")
    public Ret<Token> login(@RequestBody Account loginForm) {
        return Ret.ok(accountService.login(loginForm));
    }

    @PostMapping("")
    public Ret insert(@NotEmpty Account regForm){
        return Ret.ok(()->accountService.register(regForm));
    }

    @GetMapping("")
    public Ret<Page<Account>> pageUsers(PageRequest pageRequest, String key){
        return Ret.ok(accountService.pageUsers(pageRequest, key));
    }

    @PutMapping("/{id}/available/{available}")
    public Ret changeAccountAvailability(@PathVariable String id,@PathVariable Boolean available){
        return Ret.ok(()->accountService.changeAvailable(id, available));
    }

    @GetMapping("/{id}")
    public Ret<Account> getUserInfo(@PathVariable String id) {
        return Ret.ok(()->accountService.getById(id));
    }

    @DeleteMapping("/{id}")
    public Ret deleteUser(@PathVariable String id) {
        return Ret.ok(()->accountService.removeById(id));
    }

//    @PutMapping("/{id}")
//    public Ret modifyUserInfo(@PathVariable String id, @RequestBody Account account) {
//        return Ret.ok(()->accountService.updateUserInfo(id,userInfoForm));
//    }
}

