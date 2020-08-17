package cn.bps.heam.service;

import cn.bps.heam.domain.result.area.AreaVo;

import java.util.List;

/**
 * @author feizns
 * @since 2020/6/1
 */
public interface AreaService {

    /**
     * 获取区域子区域
     * @return
     */
    List<AreaVo> getAreaByParentId(String parentId);

    /**
     * 获取指定类型的区域
     * @param levelType
     * @return
     */
    List<AreaVo> getAreaByLevelType(int levelType);

}

