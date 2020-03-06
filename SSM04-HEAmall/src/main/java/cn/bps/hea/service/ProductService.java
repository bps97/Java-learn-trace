package cn.bps.hea.service;

import cn.bps.hea.domain.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Map<String,String> getAttributeDict(Product product);

    Map<String,String> getAttributeDict(String productId);

    Product getProduct(String productId);

    List<Product> getProducts(List<String> productIds);

    int saveProduct(Product product);

    int updateProduct(Product product);

    List<Product> listProducts();
}
