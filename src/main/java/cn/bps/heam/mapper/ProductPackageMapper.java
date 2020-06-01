package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.ProductPackage;
import cn.bps.heam.domain.model.ProductPackageExample;
import cn.bps.heam.domain.model.ProductPackageKey;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ProductPackageMapper {
    int insert(ProductPackage record);

    int insertSelective(ProductPackage record);

    List<ProductPackage> selectByExampleWithRowbounds(ProductPackageExample example, RowBounds rowBounds);

    List<ProductPackage> selectByExample(ProductPackageExample example);

    ProductPackage selectByPrimaryKey(ProductPackageKey key);

    int updateByPrimaryKeySelective(ProductPackage record);

    int updateByPrimaryKey(ProductPackage record);
}