package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.ProductInstance;
import cn.bps.heam.domain.model.ProductInstanceExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ProductInstanceMapper {
    long countByExample(ProductInstanceExample example);

    int insert(ProductInstance record);

    int insertSelective(ProductInstance record);

    List<ProductInstance> selectByExampleWithRowbounds(ProductInstanceExample example, RowBounds rowBounds);

    List<ProductInstance> selectByExample(ProductInstanceExample example);

    ProductInstance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductInstance record);

    int updateByPrimaryKey(ProductInstance record);
}