package cn.bps.heam.controller;

import cn.bps.common.lang.api.Filter;
import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.domain.Ret;
import cn.bps.heam.dict.Column;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.PortalCategory;
import cn.bps.heam.domain.model.Product;
import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.service.PortalCategoryService;
import cn.bps.heam.service.ProductAttributeService;
import cn.bps.heam.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
public class HomeController {

    @Resource
    private ProductAttributeService productAttributeService;

    @Resource
    private ProductService productService;

    @Resource
    private PortalCategoryService portalCategoryService;

    @PostMapping("/attrs")
    public Ret<List<ProductAttribute>> listProductAttributes(){
        List<ProductAttribute> productAttributes = productAttributeService.listProductAttributes();
        return Ret.ok(productAttributes);
    }



    // 主页一些产品  建议延迟加载
    @PostMapping("/products")
    public Ret<Page<Product>> homeProduct(){

        PageRequest pageRequest = new PageRequest();
        pageRequest.setPage(1);
        pageRequest.setSize(5);

//        List<PortalCategory> portalCategories = portalCategoryService.listPortalCategories();

        Filter filter = Filter.condition();
//        for(PortalCategory category : portalCategories){
            filter.addEqualTo(Column.category.name(), "冰箱");
//        }
        return Ret.ok(productService.pageProducts(pageRequest,filter));
    }

}
