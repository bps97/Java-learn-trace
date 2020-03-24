package cn.bps.hea.mapper;

import cn.bps.hea.domain.model.PortalCategory;

public interface PortalCategoryMapper {
    int insert(PortalCategory record);

    int insertSelective(PortalCategory record);
}