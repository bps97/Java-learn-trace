package cn.bps.heam.controller;

import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.domain.Ret;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.Product;
import cn.bps.heam.domain.result.ProductResult;
import cn.bps.heam.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Resource
    private ProductService productService;

    @PostMapping("/products")
    public Ret<Page<ProductResult>> pageProduct(PageRequest pageRequest){
        return Ret.ok(productService.pageProducts(pageRequest));
    }

}
