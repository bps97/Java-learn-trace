package cn.bps.heam.service.impl;

import cn.bps.heam.domain.model.Price;
import cn.bps.heam.domain.model.template.PriceExample;
import cn.bps.heam.mapper.PriceMapper;
import cn.bps.heam.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author feizns
 * @since 2020/6/1
 */
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceMapper priceMapper;

    @Override
    public BigDecimal getServicePrice(String id) {
        Price price = priceMapper.selectOneByExample(PriceExample.serviceId(id));
        return price != null ? price.getPrice() : null;
    }

    @Override
    public BigDecimal getProductPrice(String id) {
        Price price = priceMapper.selectOneByExample(PriceExample.productId(id));
        return price != null ? price.getPrice() : null;
    }

    @Override
    public BigDecimal getPrice(Price.Type type, String id) {
        if ( type == Price.Type.PRODUCT )
            return getProductPrice(id);
        else if ( type == Price.Type.SERVICE )
            return getServicePrice(id);
        return null;
    }

    @Override
    public void insert(Price.Type type, String id, BigDecimal price) {
        Price m = create(type, id, price);
        priceMapper.insert(m);
    }

    @Override
    public void update(Price p) {
        priceMapper.updateByPrimaryKey(p);
    }

    @Override
    public void delete(String id) {
        priceMapper.deleteByPrimaryKey(id);
    }

    private Price create(Price.Type type, String id, BigDecimal price) {
        Price m = new Price();
        m.setPrice(price);
        m.setType(type.getValue());
        if ( type == Price.Type.PRODUCT )
            m.setProductId(id);
        else if ( type == Price.Type.SERVICE )
            m.setServiceId(id);
        return m;
    }

}
