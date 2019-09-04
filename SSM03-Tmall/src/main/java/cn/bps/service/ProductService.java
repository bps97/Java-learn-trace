package cn.bps.service;

import cn.bps.pojo.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {
    List<Product> getProductList(int start, int step);

    List<Product> getProductListByProductIdSet(Set<Integer> set);

    List<Product> rowBoundsProduct(Set<Integer> set,Integer start,Integer step);
}
