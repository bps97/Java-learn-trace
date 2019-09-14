package cn.bps.service;

import cn.bps.pojo.Order;
import cn.bps.pojo.ProductItem;

import java.util.List;

public interface OrderService {


    String generatorOrder(int userId);
    Order getOrderByOrderCode(String orderCode);

    Order summitOrder(String orderCode, String message, Integer addressId);
}
