package cn.bps.mapper;

import cn.bps.pojo.FilterCase;
import cn.bps.pojo.FilterCaseExample;
import java.util.List;

public interface FilterCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FilterCase record);

    int insertSelective(FilterCase record);

    List<FilterCase> selectByExample(FilterCaseExample example);

    FilterCase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FilterCase record);

    int updateByPrimaryKey(FilterCase record);
}