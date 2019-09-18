package cn.bps.service;

import cn.bps.mapper.OrderItemMapper;
import cn.bps.pojo.Order;
import cn.bps.pojo.OrderItem;
import cn.bps.pojo.OrderItemExample;
import cn.bps.pojo.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImp implements OrderItemService {

    @Autowired
    OrderItemMapper orderItemMapper;


    @Override
    public int addOrderItem(OrderItem orderProductItem) {
        return orderItemMapper.insert(orderProductItem);
    }

    @Override
    public int addOrderItem(String orderCode, ProductItem productItem) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder_code(orderCode);
        orderItem.setProduct_id(productItem.getProduct_id());
        orderItem.setQuality(productItem.getQuality());
        return orderItemMapper.insert(orderItem);
    }

    @Override
    public void addOrderItems(String orderCode, List<ProductItem> productItems) {

        for(ProductItem productItem : productItems){
            addOrderItem(orderCode,productItem);
        }
        return;
    }

    @Override
    public List<OrderItem> getProductIds(Order order) {

        OrderItemExample orderItemExample = new OrderItemExample();
        orderItemExample.createCriteria().andOrder_codeEqualTo(order.getOrder_code());
        return  orderItemMapper.selectByExample(orderItemExample);

    }


}
