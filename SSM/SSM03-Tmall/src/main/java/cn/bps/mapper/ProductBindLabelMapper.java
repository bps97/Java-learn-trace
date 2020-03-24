package cn.bps.mapper;

import cn.bps.pojo.ProductBindLabel;
import cn.bps.pojo.ProductBindLabelExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ProductBindLabelMapper {
    long countByExample(ProductBindLabelExample example);

    int deleteByExample(ProductBindLabelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductBindLabel record);

    int insertSelective(ProductBindLabel record);

    List<ProductBindLabel> selectByExampleWithRowbounds(ProductBindLabelExample example, RowBounds rowBounds);

    List<ProductBindLabel> selectByExample(ProductBindLabelExample example);

    ProductBindLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductBindLabel record);

    int updateByPrimaryKey(ProductBindLabel record);
}