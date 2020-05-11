package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.PortalCategory;
import cn.bps.heam.domain.model.PortalCategoryExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface PortalCategoryMapper {
    long countByExample(PortalCategoryExample example);

    int insert(PortalCategory record);

    int insertSelective(PortalCategory record);

    List<PortalCategory> selectByExampleWithRowbounds(PortalCategoryExample example, RowBounds rowBounds);

    List<PortalCategory> selectByExample(PortalCategoryExample example);
}