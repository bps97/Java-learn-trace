package cn.bps.mapper;

import cn.bps.pojo.ConcreteFilter;
import cn.bps.pojo.ConcreteFilterExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ConcreteFilterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConcreteFilter record);

    int insertSelective(ConcreteFilter record);

    List<ConcreteFilter> selectByExampleWithRowbounds(ConcreteFilterExample example, RowBounds rowBounds);

    List<ConcreteFilter> selectByExample(ConcreteFilterExample example);

    ConcreteFilter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConcreteFilter record);

    int updateByPrimaryKey(ConcreteFilter record);
}