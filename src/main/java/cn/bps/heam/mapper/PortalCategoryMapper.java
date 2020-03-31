package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.PortalCategory;

public interface PortalCategoryMapper {
    int insert(PortalCategory record);

    int insertSelective(PortalCategory record);
}