package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.ValueAddedService;
import cn.bps.heam.domain.model.template.ValueAddedServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ValueAddedServiceMapper {
    long countByExample(ValueAddedServiceExample example);

    int deleteByExample(ValueAddedServiceExample example);

    int deleteByPrimaryKey(String id);

    int insert(ValueAddedService record);

    int insertSelective(ValueAddedService record);

    List<ValueAddedService> selectByExampleWithRowbounds(ValueAddedServiceExample example, RowBounds rowBounds);

    List<ValueAddedService> selectByExample(ValueAddedServiceExample example);

    ValueAddedService selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ValueAddedService record, @Param("example") ValueAddedServiceExample example);

    int updateByExample(@Param("record") ValueAddedService record, @Param("example") ValueAddedServiceExample example);

    int updateByPrimaryKeySelective(ValueAddedService record);

    int updateByPrimaryKey(ValueAddedService record);
}