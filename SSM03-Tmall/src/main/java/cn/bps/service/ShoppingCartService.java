package cn.bps.service;

import cn.bps.pojo.Product;
import cn.bps.pojo.ShoppingCart;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ShoppingCartService {

    List<ShoppingCart> getShoppingCartProductByUserId(int userId);

    float countTotalPrice(int userId);

    float countTotalPrice(List<Integer> shoppingCartIDs);

    int removeOne(int shopId);

    int insertOne(ShoppingCart shoppingCart);

    int insertOne(int productId, int userId, int quality);


    List<ShoppingCart> getShoppingCartByIds(List<Integer> itemIds);

    Integer updateItemQualityByItemId(int itemId, int quality);


//    boolean isProductExist(int productId);
}
