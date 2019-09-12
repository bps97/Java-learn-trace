package cn.bps.service;

import cn.bps.pojo.ShoppingCart;

import java.util.List;

public interface OrderService {

    List<ShoppingCart> getProductItemByItemIds(List<Integer> itemIds);
}
