package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.heam.domain.model.ProductCategoryExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ProductCategoryMapper {
    long countByExample(ProductCategoryExample example);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    List<ProductCategory> selectByExampleWithRowbounds(ProductCategoryExample example, RowBounds rowBounds);

    List<ProductCategory> selectByExample(ProductCategoryExample example);

    ProductCategory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}