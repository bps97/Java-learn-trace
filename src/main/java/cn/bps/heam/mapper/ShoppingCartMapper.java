package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.ShoppingCart;
import cn.bps.heam.domain.model.ShoppingCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ShoppingCartMapper {
    long countByExample(ShoppingCartExample example);

    int deleteByExample(ShoppingCartExample example);

    int deleteByPrimaryKey(String id);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    List<ShoppingCart> selectByExampleWithRowbounds(ShoppingCartExample example, RowBounds rowBounds);

    List<ShoppingCart> selectByExample(ShoppingCartExample example);

    ShoppingCart selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    int updateByExample(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
}