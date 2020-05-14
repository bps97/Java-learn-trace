package cn.bps.heam.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.heam.domain.model.Commercial;
import cn.bps.heam.domain.model.CommercialExample;
import cn.bps.heam.domain.result.CommercialResult;
import cn.bps.heam.mapper.CommercialMapper;
import cn.bps.heam.service.CommercialService;
import cn.bps.heam.service.ResourceUriService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommercialServiceImpl implements CommercialService {

    @Resource
    private CommercialMapper commercialMapper;

    @Resource
    private ResourceUriService resourceUriService;

    @Override
    public List<CommercialResult> listCommercials() {
        List<Commercial> commercials = commercialMapper.selectByExample(new CommercialExample());
        return commercials.stream().map(e->model2Result(e)).collect(Collectors.toList());
    }

    @Override
    public int updateCommercial(Commercial commercial) {
        CommercialExample commercialExample = new CommercialExample();
        commercialExample.createCriteria().andIdEqualTo(commercial.getId());
        return commercialMapper.updateByExampleSelective(commercial,commercialExample);
    }

    @Override
    public int saveCommercial(Commercial commercial) {
        return 0;
    }

    @Override
    public Commercial getCommercial(String id) {
        Commercial commercial = commercialMapper.selectByPrimaryKey(id);
        if(Objects.isNull(commercial))
            throw new LocalBizServiceException(CustomizeExceptionCode.COMMERCIAL_NOT_EXIST, id);
        return commercial;

    }

    @Override
    public Commercial getCommercial(Integer index) {
        CommercialExample commercialExample = new CommercialExample();
        commercialExample.createCriteria().andAvailableEqualTo(true).andPortalIndexEqualTo(index);
        List<Commercial> commercials = commercialMapper.selectByExample(commercialExample);
        if(Objects.isNull(commercials))
            throw new LocalBizServiceException(CustomizeExceptionCode.COMMERCIAL_NOT_EXIST);
        return commercials.get(0);
    }

    private CommercialResult model2Result(Commercial commercial) {
        CommercialResult result = new CommercialResult();

        String imgUri = resourceUriService.getUri(commercial.getImgUriId());
        result.setImgUri(imgUri);
        result.setInfo(commercial.getInfo());
        // result.setPoint(commercial.getPoint());
        result.setPortalIndex(commercial.getPortalIndex());
        return result;
    }
}
