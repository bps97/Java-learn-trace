package cn.bps.hea.mapper;

import cn.bps.hea.domain.model.Product;
import cn.bps.hea.domain.model.ProductExample;
import java.util.List;

public interface ProductMapper {
    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}