package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.Product;
import cn.bps.heam.domain.model.ProductExample;
import java.util.List;

public interface ProductMapper {
    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}