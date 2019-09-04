package cn.bps.mapper;

import cn.bps.pojo.FilterCase;
import cn.bps.pojo.FilterCaseExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface FilterCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FilterCase record);

    int insertSelective(FilterCase record);

    List<FilterCase> selectByExampleWithRowbounds(FilterCaseExample example, RowBounds rowBounds);

    List<FilterCase> selectByExample(FilterCaseExample example);

    FilterCase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FilterCase record);

    int updateByPrimaryKey(FilterCase record);
}