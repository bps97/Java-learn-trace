package cn.bps.service;


import cn.bps.mapper.OrderMapper;
import cn.bps.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    private OrderMapper orderMapper;



    @Override
    public Order generatorOrder() {

        Order order = new Order();
        Date now = new Date();
        String orderCode = "";
        order.setOrder_code("xx");

        return null;
    }
}
