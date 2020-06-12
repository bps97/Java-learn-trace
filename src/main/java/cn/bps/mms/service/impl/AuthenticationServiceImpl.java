package cn.bps.mms.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.mms.entity.Authentication;
import cn.bps.mms.mapper.AuthenticationMapper;
import cn.bps.mms.service.AuthenticationService;
import cn.bps.mms.vo.AuthenticationVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 账户基本信息 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@Service
public class AuthenticationServiceImpl extends ServiceImpl<AuthenticationMapper, Authentication> implements AuthenticationService {

    @Resource
    private AuthenticationMapper authenticationMapper;

    @Override
    public List<AuthenticationVo> listAuthentications() {
        List<Authentication> rootAuthentications = rootsAuthentications();
        List<AuthenticationVo> listAuthentications = model2Vo(rootAuthentications);
        return listAuthentications;
    }


    @Override
    public List<Authentication> rootsAuthentications() {
        QueryWrapper<Authentication> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .isNull("parent_id")
                .orderByAsc("portal_index");

        List<Authentication> rootAuthentications = this.list(wrapper);

        if(Objects.isNull(rootAuthentications) || rootAuthentications.isEmpty()){
            throw new LocalBizServiceException(CustomizeExceptionCode.AUTHENTICATION_NOT_EXIST);
        }
        return rootAuthentications;
    }

    @Override
    public List<AuthenticationVo> listAllAuthentication() {
        QueryWrapper<Authentication> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .orderByAsc("portal_index");

        List<Authentication> authentications = this.list(wrapper);
        return model2Vo(authentications);
    }


    @Override
    public List<Authentication> getChildren(String parentId) {
        QueryWrapper<Authentication> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("parent_id", parentId);
        List<Authentication> authentications = this.list(wrapper);
        return  authentications;
    }

    @Override
    public IPage<Authentication> pageAuthentications(Page<Authentication> page) {
        return authenticationMapper.selectPage(page,new QueryWrapper<>());
    }


    private List<AuthenticationVo> model2Vo(List<Authentication> rootAuthentications) {

        List<AuthenticationVo> lists = Lists.newArrayList();

        for(Authentication parent: rootAuthentications){
            List<Authentication> children = getChildren(parent.getId());
            AuthenticationVo vo = new AuthenticationVo();
            vo.setAuthName(parent.getAuthName());
            vo.setChildren(model2Vo(children));
            vo.setId(parent.getId());
            vo.setPath(parent.getPath());
            vo.setIndex(parent.getPortalIndex());
            lists.add(vo);
        }
        return lists.isEmpty() ? null: lists;
    }

}
