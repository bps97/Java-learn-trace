package cn.bps.mapper;

import cn.bps.pojo.FilterValue;
import cn.bps.pojo.FilterValueExample;
import java.util.List;

public interface FilterValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FilterValue record);

    int insertSelective(FilterValue record);

    List<FilterValue> selectByExample(FilterValueExample example);

    FilterValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FilterValue record);

    int updateByPrimaryKey(FilterValue record);
}