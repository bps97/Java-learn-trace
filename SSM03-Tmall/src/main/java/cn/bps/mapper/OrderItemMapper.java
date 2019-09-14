package cn.bps.mapper;

import cn.bps.pojo.OrderItem;
import cn.bps.pojo.OrderItemExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface OrderItemMapper {
    int deleteByExample(OrderItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    List<OrderItem> selectByExampleWithRowbounds(OrderItemExample example, RowBounds rowBounds);

    List<OrderItem> selectByExample(OrderItemExample example);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}