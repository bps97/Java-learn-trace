package cn.bps.heam.service;


import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.api.Filter;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.Product;
import cn.bps.heam.domain.model.ProductInstance;
import cn.bps.heam.domain.result.HomeProductResult;
import cn.bps.heam.domain.result.ProductResult;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Map<String,String> getAttributeDict(Product product);

    Map<String,String> getAttributeDict(String productId);

    List<String> listAttributes(String productId);

    List<String> listAttributes(Product product);

    Product getProduct(String productId);


    List<Product> listProducts(List<String> productIds);

    List<Product> listProducts();

    Page<ProductResult> pageProducts(PageRequest pageRequest);


    Page<ProductResult> pageProducts(PageRequest pageRequest, Filter filter);

    HomeProductResult getHomeProduct(Filter filter);

    int saveProduct(Product product);

    int updateProduct(Product product);

    void insert(Product product);
}
