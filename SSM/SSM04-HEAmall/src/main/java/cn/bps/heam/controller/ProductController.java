package cn.bps.heam.controller;

import cn.bps.common.lang.api.Filter;
import cn.bps.common.lang.domain.Ret;
import cn.bps.heam.biz.ProductBiz;
import cn.bps.heam.dict.Column;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.result.HomeProductResult;
import com.google.common.collect.Lists;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class ProductController {

    @Resource
    private ProductBiz productBiz;

    @GetMapping("")
    public Ret listGoods(PageRequest pageRequest,String categoryName,String key){
        Filter filter = Filter.condition();
        if(StringUtils.isNotBlank(categoryName)){
            filter.addEqualTo("category",categoryName);
        }
        if(StringUtils.isNotBlank(key)){
            filter.addContains(Column.productName.name(),key);
        }
        return Ret.ok(productBiz.pageProducts(pageRequest,filter));
    }


    /**
     * @Label("主页推送的热门产品")
     * @param categoryNames 分类名称(中文)
     * @return 同一分类的产品列表
     */
    @GetMapping("/products")
    public Ret<List<HomeProductResult>> homeProducts(@RequestParam(required = false) List<String> categoryNames){
        return Ret.ok(productBiz.getHomeProduct(categoryNames));
    }

    @PostMapping("/{id}")
    public Ret getProductDetail(@PathVariable String id){
        return Ret.ok(productBiz.getProduct(id));
    }
}
