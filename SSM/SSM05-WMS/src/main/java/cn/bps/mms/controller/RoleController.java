package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.model.pojo.Role;
import cn.bps.mms.service.RoleService;
import io.swagger.annotations.Api;
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
@Api(tags = "角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 获取角色列表
     * @return
     */
    @GetMapping("/list")
    public Ret<List<Role>> listRoles(){
        return Ret.ok(roleService.list());
    }

}

