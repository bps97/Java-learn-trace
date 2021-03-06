package cn.bps.service;

import cn.bps.pojo.OrderItem;
import cn.bps.pojo.Product;
import cn.bps.pojo.ProductImage;
import cn.bps.pojo.ProductItem;

import java.util.List;

public interface ShoppingCartService {

    List<ProductItem> getShoppingCartProductByUserId(int userId);

    float countTotalPrice(int userId);

    float countTotalPriceByProductItemIds(List<Integer> productItemIds);

    float countTotalPrice(List<ProductItem> productItems);

    long countProductItem(int userId);

    int removeOne(int shopId);

    int insertOne(ProductItem productItem);

    int insertOne(int productId, int userId, int quality);


    List<ProductItem> getShoppingCartByIds(List<Integer> itemIds);

    Integer updateItemQualityByItemId(int itemId, int quality);

    ProductItem findProductInShoppingCart(int productId,int userId); //查看购物车内是否与该产品一致的产品，有则返回一致产品

    Integer ProductQualityAdd(ProductItem productItem);


    int removeProductItemsByIds(List<Integer> itemList);


//    boolean isProductExist(int productId);
}
