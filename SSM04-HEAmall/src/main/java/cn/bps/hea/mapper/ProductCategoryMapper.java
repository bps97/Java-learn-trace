package cn.bps.hea.mapper;

import cn.bps.hea.domain.model.ProductCategory;
import cn.bps.hea.domain.model.ProductCategoryExample;
import java.util.List;

public interface ProductCategoryMapper {
    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    List<ProductCategory> selectByExample(ProductCategoryExample example);

    ProductCategory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}