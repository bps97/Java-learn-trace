package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.ProductAttributeDict;
import cn.bps.heam.domain.model.ProductAttributeDictExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ProductAttributeDictMapper {
    int insert(ProductAttributeDict record);

    int insertSelective(ProductAttributeDict record);

    List<ProductAttributeDict> selectByExampleWithRowbounds(ProductAttributeDictExample example, RowBounds rowBounds);

    List<ProductAttributeDict> selectByExample(ProductAttributeDictExample example);

    int updateByPrimaryKeySelective(ProductAttributeDict record);

    int updateByPrimaryKey(ProductAttributeDict record);
}