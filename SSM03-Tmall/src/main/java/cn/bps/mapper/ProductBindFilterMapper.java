package cn.bps.mapper;

import cn.bps.pojo.ProductBindFilter;
import cn.bps.pojo.ProductBindFilterExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ProductBindFilterMapper {
    long countByExample(ProductBindFilterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductBindFilter record);

    int insertSelective(ProductBindFilter record);

    List<ProductBindFilter> selectByExampleWithRowbounds(ProductBindFilterExample example, RowBounds rowBounds);

    List<ProductBindFilter> selectByExample(ProductBindFilterExample example);

    ProductBindFilter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductBindFilter record);

    int updateByPrimaryKey(ProductBindFilter record);
}