package cn.bps.heam.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.heam.service.PortalCategoryService;
import cn.bps.heam.service.ProductCategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private PortalCategoryService portalCategoryService;

    @Resource
    private ProductCategoryService productCategoryService;

    @PostMapping("/portal/add")
    public Ret addPortalCategory(String categoryName){
        ProductCategory productCategory = productCategoryService.getCategoryByName(categoryName);
        portalCategoryService.savePortalCategory(productCategory);
        return Ret.ok();
    }

}
