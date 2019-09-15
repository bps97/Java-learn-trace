package cn.bps.service;


import cn.bps.mapper.OrderMapper;
import cn.bps.pojo.Order;
import cn.bps.pojo.OrderExample;
import cn.bps.util.OrderCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    private OrderMapper orderMapper;



    @Override
    public String  generatorOrder(int userId) {

        Order order = new Order();

        String orderCode = OrderCode.getOrderCode();

        order.setOrder_code(orderCode);
        order.setUser_id(userId);
        order.setStatus("未提交");

        if(orderMapper.insertSelective(order)!=0){
            return orderCode;
        }

        return null;
    }

    @Override
    public Order getOrderByOrderCode(String orderCode) {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andOrder_codeEqualTo(orderCode);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        if(orders.size()>0){
            return orders.get(0);
        }
        return null;
    }

    @Override
    public Order summitOrder(String orderCode, String message, Integer addressId, Float payment) {

        Order order = getOrderByOrderCode(orderCode);
        order.setUser_message(message);
        order.setAddress_id(addressId);
        order.setActual_payment(payment);

        Date now = new Date();
        java.sql.Date sqlNow = new java.sql.Date(now.getTime());
        order.setCreate_date(sqlNow);
        order.setStatus("未支付");

        if(orderMapper.updateByPrimaryKey(order)!=0){
            return order;
        }

        return null;

    }
}
