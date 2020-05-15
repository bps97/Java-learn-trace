package cn.bps.heam.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.heam.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;

/* 运营端 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private CategoryService categoryService;

    /**
     * @Label("添加门户页面分类")
     * @param categoryName 分类名称
     * @return
     */
    @PostMapping("/portal/add")
    public Ret addPortalCategory(@NotEmpty String categoryName){
        categoryService.savePortalCategory(categoryName);
        return Ret.ok();
    }

}
