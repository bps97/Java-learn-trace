package cn.bps.hea.mapper;

import cn.bps.hea.domain.model.ProductInstance;
import cn.bps.hea.domain.model.ProductInstanceExample;
import java.util.List;

public interface ProductInstanceMapper {
    int insert(ProductInstance record);

    int insertSelective(ProductInstance record);

    List<ProductInstance> selectByExample(ProductInstanceExample example);

    int updateByPrimaryKeySelective(ProductInstance record);

    int updateByPrimaryKey(ProductInstance record);
}