package cn.bps.mapper;

import cn.bps.pojo.OrderProductItem;
import cn.bps.pojo.OrderProductItemExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface OrderProductItemMapper {
    int deleteByExample(OrderProductItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderProductItem record);

    int insertSelective(OrderProductItem record);

    List<OrderProductItem> selectByExampleWithRowbounds(OrderProductItemExample example, RowBounds rowBounds);

    List<OrderProductItem> selectByExample(OrderProductItemExample example);

    OrderProductItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderProductItem record);

    int updateByPrimaryKey(OrderProductItem record);
}