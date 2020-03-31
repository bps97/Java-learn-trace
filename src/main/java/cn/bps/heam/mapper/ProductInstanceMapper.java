package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.ProductInstance;
import cn.bps.heam.domain.model.ProductInstanceExample;
import java.util.List;

public interface ProductInstanceMapper {
    int insert(ProductInstance record);

    int insertSelective(ProductInstance record);

    List<ProductInstance> selectByExample(ProductInstanceExample example);

    int updateByPrimaryKeySelective(ProductInstance record);

    int updateByPrimaryKey(ProductInstance record);
}