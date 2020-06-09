package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
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
    public Ret login(@RequestBody Account loginForm) {
        return Ret.ok(accountService.login(loginForm));
    }

    @PostMapping("")
    public Ret insert(@NotEmpty Account regForm){
        return Ret.ok(()->accountService.register(regForm));
    }

    @GetMapping("")
    public Ret test(){
        return Ret.ok("123");
    }


}

