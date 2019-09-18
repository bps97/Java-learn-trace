package cn.bps.service;

import cn.bps.pojo.Address;
import cn.bps.pojo.Order;

public interface OrderService {


    String generatorOrder(int userId);
    Order getOrderByOrderCode(String orderCode);

    Order summitOrder(String orderCode, String message, Address address, Float payment);

    Order confirmOrder(String orderCode);
}
