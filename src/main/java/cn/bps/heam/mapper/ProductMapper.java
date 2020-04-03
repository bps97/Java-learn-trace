package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.Product;
import cn.bps.heam.domain.model.ProductExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExampleWithRowbounds(ProductExample example, RowBounds rowBounds);

    List<Product> selectByExample(ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}