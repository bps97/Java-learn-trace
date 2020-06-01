package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.Area;
import cn.bps.heam.domain.model.AreaExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface AreaMapper {
    long countByExample(AreaExample example);

    int deleteByPrimaryKey(Integer id);

    List<Area> selectByExampleWithRowbounds(AreaExample example, RowBounds rowBounds);

    List<Area> selectByExample(AreaExample example);

    Area selectByPrimaryKey(Integer id);
}