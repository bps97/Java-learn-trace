package cn.bps.heam.service.impl;

import cn.bps.heam.domain.model.ResourceUri;
import cn.bps.heam.mapper.ResourceUriMapper;
import cn.bps.heam.service.ResourceUriService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class ResourceUriServiceImpl implements ResourceUriService {

    @Resource
    private ResourceUriMapper resourceUriMapper;

    @Override
    public String getUri(String id) {
        ResourceUri resourceUri = resourceUriMapper.selectByPrimaryKey(id);
        return Objects.nonNull(resourceUri) ? resourceUri.getUri() : "default-uri";
    }
}
