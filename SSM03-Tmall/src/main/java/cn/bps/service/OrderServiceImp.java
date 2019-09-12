package cn.bps.service;


import cn.bps.mapper.OrderMapper;
import cn.bps.pojo.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShoppingCartService shoppingCartService;


    @Override
    public List<ProductItem> getProductItemByItemIds(List<Integer> itemIds) {
        return shoppingCartService.getShoppingCartByIds(itemIds);
    }
}
