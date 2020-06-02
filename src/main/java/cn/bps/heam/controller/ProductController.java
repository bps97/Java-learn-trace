package cn.bps.heam.controller;

import cn.bps.common.lang.api.Filter;
import cn.bps.common.lang.domain.Ret;
import cn.bps.heam.biz.ProductBiz;
import cn.bps.heam.dict.Column;
import cn.bps.heam.domain.PageRequest;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

}
