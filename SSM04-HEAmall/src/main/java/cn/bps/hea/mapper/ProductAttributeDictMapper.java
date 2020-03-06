package cn.bps.hea.mapper;

import cn.bps.hea.domain.model.ProductAttributeDict;
import cn.bps.hea.domain.model.ProductAttributeDictExample;
import java.util.List;

public interface ProductAttributeDictMapper {
    int insert(ProductAttributeDict record);

    int insertSelective(ProductAttributeDict record);

    List<ProductAttributeDict> selectByExample(ProductAttributeDictExample example);

    int updateByPrimaryKeySelective(ProductAttributeDict record);

    int updateByPrimaryKey(ProductAttributeDict record);
}