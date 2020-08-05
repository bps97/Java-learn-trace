package cn.bps.mms.controller;


import cn.bps.common.lang.api.Token;
import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.model.ao.ChangePwdAo;
import cn.bps.mms.model.vo.AccountVo;
import cn.bps.mms.model.pojo.Account;
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

    /**
     * 登录
     * @param loginForm
     * @return
     */
    @PostMapping("/login")
    public Ret<Token> login(@RequestBody Account loginForm) {
        return Ret.ok(accountService.login(loginForm));
    }

    /**
     * 添加实例
     * @param regForm
     * @return
     */
    @PostMapping("")
    public Ret insert(@RequestBody Account regForm){
        return Ret.ok(()->accountService.register(regForm));
    }

    /**
     * 分页展示用户列表
     * @param page
     * @param key
     * @return
     */
    @GetMapping("")
    public Ret<IPage<AccountVo>> pageUsers(Page<Account> page, String key){
        return Ret.ok(accountService.pageUsers(page, key));
    }

    /**
     * 修改指定实例有效性
     * @param id
     * @param available
     * @return
     */
    @PutMapping("/{id}/available/{available}")
    public Ret changeAccountAvailability(@PathVariable String id,@PathVariable Boolean available){
        return Ret.ok(()->accountService.changeAvailable(id, available));
    }

    /**
     * 修改指定用户角色ID
     * @param id
     * @param roleId
     * @return
     */
    @PutMapping("/{id}/roleId/{roleId}")
    public Ret changeAccountRoleId(@PathVariable String id,@PathVariable String roleId){
        return Ret.ok(()->accountService.changeRoleId(id, roleId));
    }

    /**
     * 获取指定用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Ret<Account> getUserInfo(@PathVariable String id) {
        return Ret.ok(accountService.getById(id));
    }

    /**
     * 删除指定用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Ret deleteUser(@PathVariable String id) {
        return Ret.ok(()->accountService.removeById(id));
    }

    /**
     * 修改指定用户信息
     * @param id
     * @param account
     * @return
     */
    @PutMapping("/{id}")
    public Ret modifyUserInfo(@PathVariable String id, @RequestBody Account account) {
        return Ret.ok(()->accountService.updateById(id, account));
    }

    /**
     * 修改密码
     * @param token
     * @param ao
     * @return
     */
    @PostMapping("/password")
    public Ret changePassword(@RequestHeader String token, @RequestBody ChangePwdAo ao){
        return Ret.ok(()->accountService.changePassword(token,ao));
    }

    /**
     * 修改用户密码
     * @param id
     * @return
     */
    @PutMapping("/{id}/password")
    public Ret changePassword(@PathVariable String id){
        return Ret.ok(()->accountService.resetPassword(id));
    }

}

