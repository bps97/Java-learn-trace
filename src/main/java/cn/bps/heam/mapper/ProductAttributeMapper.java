package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.domain.model.ProductAttributeExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ProductAttributeMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductAttribute record);

    int insertSelective(ProductAttribute record);

    List<ProductAttribute> selectByExampleWithRowbounds(ProductAttributeExample example, RowBounds rowBounds);

    List<ProductAttribute> selectByExample(ProductAttributeExample example);

    ProductAttribute selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductAttribute record);

    int updateByPrimaryKey(ProductAttribute record);
}