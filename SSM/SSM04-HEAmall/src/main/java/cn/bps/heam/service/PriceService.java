package cn.bps.heam.service;

import cn.bps.heam.domain.model.Price;

import java.math.BigDecimal;

/**
 * @author feizns
 * @since 2020/6/1
 */
public interface PriceService {

    /**
     * 获取服务价格
     * @return
     */
    BigDecimal getServicePrice(String id);

    /**
     * 获取产品价格
     * @return
     */
    BigDecimal getProductPrice(String id);

    /**
     * 获取价格
     * @return
     */
    BigDecimal getPrice(Price.Type type, String id);

    /**
     * 添加
     * @param type
     * @param id
     * @param price
     */
    void insert(Price.Type type, String id, BigDecimal price);

    /**
     * 修改
     * @param p
     */
    void update(Price p);

    /**
     * 删除
     * @param id
     */
    void delete(String id);

}

