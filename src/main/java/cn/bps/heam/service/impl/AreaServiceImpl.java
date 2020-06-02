package cn.bps.heam.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.common.utils.ModelUtils;
import cn.bps.heam.domain.model.Area;
import cn.bps.heam.domain.model.template.AreaExample;
import cn.bps.heam.domain.result.area.AreaVo;
import cn.bps.heam.mapper.AreaMapper;
import cn.bps.heam.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author feizns
 * @since 2020/6/1
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<AreaVo> getAreaByParentId(String parentId) {
        return areaMapper.selectByExample(AreaExample.parentId(parentId))
                .stream()
                .map(a -> ModelUtils.copyTo(a, AreaVo.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AreaVo> getAreaByLevelType(int levelType) {
        Area.Level level = Area.Level.resolve(levelType);
        if ( level == null )
            throw new LocalBizServiceException(CustomizeExceptionCode.AREA_REGION_TYPE_DOES_NOT_EXIST);
        return areaMapper.selectByExample(AreaExample.levelType(levelType))
                .stream()
                .map(a -> ModelUtils.copyTo(a, AreaVo.class))
                .collect(Collectors.toList());
    }

}
