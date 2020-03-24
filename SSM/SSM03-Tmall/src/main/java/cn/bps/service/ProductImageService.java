package cn.bps.service;

import cn.bps.pojo.Product;
import cn.bps.pojo.ProductImage;

import java.util.Collection;
import java.util.Map;

public interface ProductImageService {
    Map<Integer,String> getImageUrls(Collection<Product> products);

    String getImageUrl(Integer productId);

    int addProductImage(Integer productId, String imgUrl);

    int deleteOneByProductId(int productId);

    int updateProductImage(Integer productId, String imgUrl);

    ProductImage getProductImageByProductId(Integer productId);
}
