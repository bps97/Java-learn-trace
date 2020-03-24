package cn.bps.mapper;

import cn.bps.pojo.Product;
import cn.bps.pojo.ProductExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExampleWithRowbounds(ProductExample example, RowBounds rowBounds);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}