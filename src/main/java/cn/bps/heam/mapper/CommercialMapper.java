package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.Commercial;
import cn.bps.heam.domain.model.CommercialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CommercialMapper {
    long countByExample(CommercialExample example);

    int deleteByExample(CommercialExample example);

    int insert(Commercial record);

    int insertSelective(Commercial record);

    List<Commercial> selectByExampleWithRowbounds(CommercialExample example, RowBounds rowBounds);

    List<Commercial> selectByExample(CommercialExample example);

    Commercial selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Commercial record, @Param("example") CommercialExample example);

    int updateByExample(@Param("record") Commercial record, @Param("example") CommercialExample example);

    int updateByPrimaryKeySelective(Commercial record);

    int updateByPrimaryKey(Commercial record);
}