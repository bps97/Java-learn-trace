package cn.bps.mapper;

import cn.bps.pojo.Property;
import cn.bps.pojo.PropertyExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface PropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Property record);

    int insertSelective(Property record);

    List<Property> selectByExampleWithRowbounds(PropertyExample example, RowBounds rowBounds);

    List<Property> selectByExample(PropertyExample example);

    Property selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}