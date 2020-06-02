package cn.bps.heam.controller;

import cn.bps.common.lang.api.Filter;
import cn.bps.common.lang.domain.Ret;
import cn.bps.heam.biz.ProductBiz;
import cn.bps.heam.dict.Column;
import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.domain.result.CommercialResult;
import cn.bps.heam.domain.result.HomeProductResult;
import cn.bps.heam.service.CommercialService;
import cn.bps.heam.service.AttributeService;
import cn.bps.heam.service.ProductInstanceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/* 门户首页 */
@RestController
public class HomeController {

    @Resource
    private AttributeService attributeService;

    @Resource
    private ProductBiz productBiz;

    @Resource
    private CommercialService commercialService;

    @PostMapping("/attrs")
    public Ret<List<ProductAttribute>> listProductAttributes(){
        List<ProductAttribute> productAttributes = attributeService.listProductAttributes();
        return Ret.ok(productAttributes);
    }


    /**
     * @Label("主页推送的热门产品")
     * @param categoryName 分类名称(中文)
     * @return 同一分类的产品列表
     */
    @PostMapping("/products")
    public Ret<HomeProductResult> homeProducts(String categoryName){



//        List<PortalCategory> portalCategories = portalCategoryService.listPortalCategories();

        Filter filter = Filter.condition();
        filter.addEqualTo(Column.category.name(), categoryName);

        return Ret.ok(productBiz.getHomeProduct(filter));
    }

    /**
     * @Label("主页推送的广告")
     * @return 广告列表
     */
    @PostMapping("/commercial")
    public Ret<List<CommercialResult>> commercials(){
        return Ret.ok(commercialService.listCommercials());
    }

}
