package cn.bps.service;

import cn.bps.pojo.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> getShoppingCartProductByUserId(int userId);
    int insertOne(ShoppingCart shoppingCart);
}
