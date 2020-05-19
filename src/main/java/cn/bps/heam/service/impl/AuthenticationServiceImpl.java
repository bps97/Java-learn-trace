package cn.bps.heam.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.heam.domain.model.Authentication;
import cn.bps.heam.domain.model.AuthenticationExample;
import cn.bps.heam.domain.result.AuthenticationResult;
import cn.bps.heam.mapper.AuthenticationMapper;
import cn.bps.heam.service.AuthenticationService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Resource
    private AuthenticationMapper authenticationMapper;

    @Override
    public List<AuthenticationResult> listAuthentications() {

        List<Authentication> rootAuthentications = rootsAuthentications();
        List<AuthenticationResult> listAuthentications = model2Result(rootAuthentications);

        return listAuthentications;
    }

    @Override
    public Authentication getAuthentication(String id) {
        return authenticationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Authentication> getChildren(String parentId) {
        AuthenticationExample authenticationExample = new AuthenticationExample();
        authenticationExample.createCriteria().andAvailableEqualTo(true).andParentIdEqualTo(parentId);
        List<Authentication> authentications =authenticationMapper.selectByExample(authenticationExample);
        return  authentications;
    }


    private List<AuthenticationResult> model2Result(List<Authentication> rootAuthentications) {

        List<AuthenticationResult> lists = Lists.newArrayList();

        for(Authentication parent: rootAuthentications){
            List<Authentication> children = getChildren(parent.getId());
            AuthenticationResult result = new AuthenticationResult();
            result.setAuthName(parent.getAuthName());
            result.setChildren(model2Result(children));
            result.setId(parent.getId());
            result.setPath(parent.getPath());
            result.setIndex(parent.getPortalIndex());

            lists.add(result);
        }
        return lists.isEmpty() ? null: lists;
    }


    public List<Authentication> rootsAuthentications() {
        AuthenticationExample authenticationExample = new AuthenticationExample();
        authenticationExample.createCriteria().andAvailableEqualTo(true).andParentIdIsNull();
        List<Authentication> rootAuthentications =authenticationMapper.selectByExample(authenticationExample);
        if(Objects.isNull(rootAuthentications) || rootAuthentications.isEmpty()){
            throw new LocalBizServiceException(CustomizeExceptionCode.AUTHENTICATION_NOT_EXIST);
        }
        return rootAuthentications;
    }
}
