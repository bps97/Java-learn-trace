package cn.bps.service;


import cn.bps.pojo.Order;
import cn.bps.pojo.OrderItem;
import cn.bps.pojo.ProductItem;

import java.util.List;

public interface OrderItemService {

    int addOrderItem(OrderItem orderItem);
    int addOrderItem(String orderCode,ProductItem productItem);


    void addOrderItems(String orderCode, List<ProductItem> productItems);
}
