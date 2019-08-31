package cn.bps.mapper;

import cn.bps.pojo.Filter;
import cn.bps.pojo.FilterExample;
import java.util.List;

public interface FilterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Filter record);

    int insertSelective(Filter record);

    List<Filter> selectByExample(FilterExample example);

    Filter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Filter record);

    int updateByPrimaryKey(Filter record);
}