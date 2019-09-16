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

    ProductItem findProductInShoppingCart(int productId); //查看购物车内是否与该产品一致的产品，有则返回一致产品

    Integer ProductQualityAdd(ProductItem productItem);


//    boolean isProductExist(int productId);
}
