package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.entity.Privilege;
import cn.bps.mms.service.PrivilegeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-07-01
 */
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

    @Resource
    private PrivilegeService privilegeService;

    @GetMapping("/page")
    public Ret<IPage<Privilege>> pagePrivileges(Page<Privilege> page){
        return Ret.ok(privilegeService.page(page));
    }

    @GetMapping("/list")
    public Ret<List<Privilege>> listPrivileges(){
        return Ret.ok(privilegeService.listPrivileges());
    }

}

