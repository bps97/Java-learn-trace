package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.entity.Authentication;
import cn.bps.mms.service.AuthenticationService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/auth")
public class AuthenticationController {

    @Resource
    private AuthenticationService authenticationService;

    @GetMapping("/menus")
    public Ret listAuthentications(){
        return Ret.ok(authenticationService.listAuthentications());
    }

    @GetMapping("")
    public Ret pageAuthentications(Page<Authentication> page) {
        return Ret.ok(authenticationService.pageAuthentications(page));
    }
}

