package cn.bps.service;

import cn.bps.pojo.Product;
import cn.bps.pojo.ProductImage;
import cn.bps.pojo.ProductItem;

import java.util.List;

public interface ShoppingCartService {

    List<ProductItem> getShoppingCartProductByUserId(int userId);

    float countTotalPrice(int userId);

    float countTotalPriceByProductItemIds(List<Integer> productItemIds);

    float countTotalPrice(List<ProductItem> productItems);

    int removeOne(int shopId);

    int insertOne(ProductItem productItem);

    int insertOne(int productId, int userId, int quality);


    List<ProductItem> getShoppingCartByIds(List<Integer> itemIds);

    Integer updateItemQualityByItemId(int itemId, int quality);


//    boolean isProductExist(int productId);
}
