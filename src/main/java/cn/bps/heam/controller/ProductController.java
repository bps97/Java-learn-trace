package cn.bps.heam.controller;

import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.domain.Ret;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.Product;
import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.service.ProductAttributeService;
import cn.bps.heam.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {

    @Resource
    private ProductAttributeService productAttributeService;

    @Resource
    private ProductService productService;

    @PostMapping("/attrs")
    public Ret<List<ProductAttribute>> listProductAttributes(){
        List<ProductAttribute> productAttributes = productAttributeService.listProductAttributes();
        return Ret.ok(productAttributes);
    }

    @PostMapping("/products")
    public Ret<Page<Product>> pageProduct(PageRequest pageRequest){
        return Ret.ok(productService.pageProducts(pageRequest));
    }
}
