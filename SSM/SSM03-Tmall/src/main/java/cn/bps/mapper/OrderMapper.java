package cn.bps.mapper;

import cn.bps.pojo.Order;
import cn.bps.pojo.OrderExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExampleWithRowbounds(OrderExample example, RowBounds rowBounds);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}