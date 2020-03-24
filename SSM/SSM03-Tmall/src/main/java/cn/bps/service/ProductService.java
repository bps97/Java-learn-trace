package cn.bps.service;

import cn.bps.pojo.Product;
import cn.bps.pojo.ProductImage;
import cn.bps.pojo.ProductItem;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {
    List<Product> getProductList(int start, int step);

    List<Product> getProductListByProductIdSet(Set<Integer> set);

    List<Product> rowBoundsProduct(Set<Integer> set, Integer start,Integer step,boolean visual);

    List<Product> rowBoundsProduct(Set<Integer> set, Integer start,Integer step ,String sortPattern);

    List<Product> rowBoundsProduct(Set<Integer> set, Integer start, Integer step, String sortPattern, boolean visual);

    Product getProductById(Integer id);

    int deleteOneById(Integer id);

    int insertOne(Product product);

    int updateOne(Product product);

    Product editOne(Product product);

    int getRecentProductId(Product product);

    Set<Integer> getProductIdSetByKey(String name);

    Map<Integer,Product> getProductMapByShoppingCartList(List<ProductItem> shoppingCarts);

    Product clone(Product product);

    int undercarriage(Product product);

    List<Product> sortProductList(List<Product> productList,String pattern);

}
