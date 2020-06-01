package cn.bps.heam.service;


import cn.bps.common.lang.api.Filter;
import cn.bps.common.lang.api.Page;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.Product;
import cn.bps.heam.domain.result.HomeProductResult;
import cn.bps.heam.domain.result.ProductResult;

import java.util.List;
import java.util.Map;

public interface ProductInstanceService {


    List<Product> listProducts(List<String> productIds);

    List<Product> listProducts();

    Page<ProductResult> pageProducts(PageRequest pageRequest);

    Page<ProductResult> pageProducts(PageRequest pageRequest, Filter filter);

    HomeProductResult getHomeProduct(Filter filter);

    int saveProduct(Product product);

    int updateProduct(Product product);

}
