package cn.bps.mapper;

import cn.bps.pojo.ProductItem;
import cn.bps.pojo.ProductItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ProductItemMapper {
    long countByExample(ProductItemExample example);

    int deleteByExample(ProductItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductItem record);

    int insertSelective(ProductItem record);

    List<ProductItem> selectByExampleWithRowbounds(ProductItemExample example, RowBounds rowBounds);

    List<ProductItem> selectByExample(ProductItemExample example);

    ProductItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductItem record, @Param("example") ProductItemExample example);

    int updateByExample(@Param("record") ProductItem record, @Param("example") ProductItemExample example);

    int updateByPrimaryKeySelective(ProductItem record);

    int updateByPrimaryKey(ProductItem record);
}