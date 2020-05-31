package cn.bps.heam.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.enums.CompositeMode;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.heam.service.AccountService;
import cn.bps.heam.service.AuthenticationService;
import cn.bps.heam.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

/* 运营端 */
@RestController
@RequestMapping("/")
public class AdminController {

    @Resource
    private CategoryService categoryService;

    @Resource
    private AuthenticationService authenticationService;

    @Resource
    private AccountService accountService;

    /**
     * @Label("添加门户页面分类")
     * @param categoryName 分类名称
     * @return
     */
    @PostMapping("/portal/add")
    public Ret addPortalCategory(@NotEmpty String categoryName){
        return Ret.ok(() -> categoryService.savePortalCategory(categoryName));
    }

    @GetMapping("/menus")
    public Ret listAuthentications(){
        return Ret.ok(authenticationService.listAuthentications());
    }


    @GetMapping("/rights/list")
    public Ret listAllAuthentications(){
        return Ret.ok(authenticationService.listAuthentications(CompositeMode.horizontal));
    }





}
