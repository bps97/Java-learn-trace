package cn.bps.hea.mapper;

import cn.bps.hea.domain.model.ProductAttribute;
import cn.bps.hea.domain.model.ProductAttributeExample;
import java.util.List;

public interface ProductAttributeMapper {
    int insert(ProductAttribute record);

    int insertSelective(ProductAttribute record);

    List<ProductAttribute> selectByExample(ProductAttributeExample example);

    int updateByPrimaryKeySelective(ProductAttribute record);

    int updateByPrimaryKey(ProductAttribute record);
}