package cn.bps.service;

import cn.bps.pojo.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {
    List<Product> getProductList(int start, int step);

    List<Product> getProductListByFilter(Set<Integer> set);
}
