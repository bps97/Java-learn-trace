package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.ProductPackage;
import cn.bps.heam.domain.model.ProductPackageExample;
import java.util.List;

public interface ProductPackageMapper {
    int insert(ProductPackage record);

    int insertSelective(ProductPackage record);

    List<ProductPackage> selectByExample(ProductPackageExample example);

    int updateByPrimaryKeySelective(ProductPackage record);

    int updateByPrimaryKey(ProductPackage record);
}