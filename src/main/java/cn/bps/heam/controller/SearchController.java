package cn.bps.heam.controller;

import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.domain.Ret;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.PortalCategory;
import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.heam.domain.result.ProductResult;
import cn.bps.heam.service.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 检索页
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    @Resource
    private ProductInstanceService productInstanceService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private AttributeService attributeService;

    /**
     * @Label("以分页的形式查看所有产品")
     * @param pageRequest
     * @return
     */
    @PostMapping("/products")
    public Ret<Page<ProductResult>> pageProduct(PageRequest pageRequest){
        return Ret.ok(productInstanceService.pageProducts(pageRequest));
    }

    @PostMapping("/categories")
    public Ret<List<PortalCategory>> listCategories(){
        return Ret.ok(categoryService.listPortalCategories());
    }

    /**
     * 显示指定分离绑定的属性列表
     * @param category 指分类名称(中文)或者分类ID
     * @return
     */
    @PostMapping("attrs")
    public Ret<List<ProductAttribute>> listAttrs(String category){
        String categoryId = null;
        try {
            ProductCategory productCategory = categoryService.getCategoryByName(category);
            categoryId = productCategory.getId();    /*传入的参数是categoryName*/
        }catch (LocalBizServiceException e){
            categoryId = category;  /*传入的参数是categoryId*/
        }
        return Ret.ok(attributeService.listProductAttributes(categoryId));
    }

}
