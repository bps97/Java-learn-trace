package cn.bps.mms.controller;


import cn.bps.common.lang.api.Token;
import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.entity.Account;
import cn.bps.mms.service.AccountService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

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
    public Ret insert(@RequestBody Account regForm){
        return Ret.ok(()->accountService.register(regForm));
    }

    @GetMapping("")
    public Ret<IPage<Account>> pageUsers(Page<Account> page, String key){
        return Ret.ok(accountService.pageUsers(page, key));
    }

    @PutMapping("/{id}/available/{available}")
    public Ret changeAccountAvailability(@PathVariable String id,@PathVariable Boolean available){
        return Ret.ok(()->accountService.changeAvailable(id, available));
    }

    @GetMapping("/{id}")
    public Ret<Account> getUserInfo(@PathVariable String id) {
        return Ret.ok(accountService.getById(id));
    }

    @DeleteMapping("/{id}")
    public Ret deleteUser(@PathVariable String id) {
        return Ret.ok(()->accountService.removeById(id));
    }

    @PutMapping("/{id}")
    public Ret modifyUserInfo(@PathVariable String id, @RequestBody Account account) {
        return Ret.ok(()->accountService.updateById(id, account));
    }


}

