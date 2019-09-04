package cn.bps.service;

import cn.bps.pojo.Product;

import java.util.List;
import java.util.Map;

public interface ProductImageService {
    Map<Integer,String> getImageUrl(List<Product> products);
}
