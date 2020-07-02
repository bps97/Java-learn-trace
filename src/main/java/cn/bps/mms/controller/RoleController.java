package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.entity.Role;
import cn.bps.mms.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @GetMapping("/roles")
    public Ret<List<Role>> listRoles(){
        return Ret.ok(roleService.list());
    }

}

