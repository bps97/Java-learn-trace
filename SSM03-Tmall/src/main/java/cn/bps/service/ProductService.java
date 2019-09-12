package cn.bps.service;

import cn.bps.pojo.Product;
import cn.bps.pojo.ProductItem;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {
    List<Product> getProductList(int start, int step);

    List<Product> getProductListByProductIdSet(Set<Integer> set);

    List<Product> rowBoundsProduct(Set<Integer> idSet, Integer start, Integer step);

    Product getProductById(Integer id);

    int deleteOneById(Integer id);

    int insertOne(Product product);

    int updateOne(Product product);

    Set<Integer> getProductIDSetByProductName(String name);

    Map<Integer,Product> getProductMapByShoppingCartList(List<ProductItem> shoppingCarts);


}
