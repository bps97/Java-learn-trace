package cn.bps.service;

import cn.bps.mapper.OrderItemMapper;
import cn.bps.pojo.OrderItem;
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
    public int addOrderItem(String orderCode, int productItemId) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder_code(orderCode);
        orderItem.setProduct_item_id(productItemId);
        return orderItemMapper.insert(orderItem);
    }

    @Override
    public int addOrderItems(String orderCode, List<ProductItem> productItems) {

        for(ProductItem productItem : productItems){
            addOrderItem(orderCode,productItem.getId());
        }

        return 0;
    }
}
