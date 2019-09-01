package cn.bps.mapper;

import cn.bps.pojo.ConcreteProperty;
import cn.bps.pojo.ConcretePropertyExample;
import java.util.List;

public interface ConcretePropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConcreteProperty record);

    int insertSelective(ConcreteProperty record);

    List<ConcreteProperty> selectByExample(ConcretePropertyExample example);

    ConcreteProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConcreteProperty record);

    int updateByPrimaryKey(ConcreteProperty record);
}