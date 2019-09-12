package cn.bps.service;

import cn.bps.pojo.ProductItem;

import java.util.List;

public interface OrderService {

    List<ProductItem> getProductItemByItemIds(List<Integer> itemIds);
}
