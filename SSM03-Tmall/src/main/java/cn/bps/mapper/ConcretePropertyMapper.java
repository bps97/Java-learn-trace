package cn.bps.mapper;

import cn.bps.pojo.ConcreteProperty;
import cn.bps.pojo.ConcretePropertyExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ConcretePropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConcreteProperty record);

    int insertSelective(ConcreteProperty record);

    List<ConcreteProperty> selectByExampleWithRowbounds(ConcretePropertyExample example, RowBounds rowBounds);

    List<ConcreteProperty> selectByExample(ConcretePropertyExample example);

    ConcreteProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConcreteProperty record);

    int updateByPrimaryKey(ConcreteProperty record);
}