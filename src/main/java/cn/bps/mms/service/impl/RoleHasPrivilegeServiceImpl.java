package cn.bps.mms.service.impl;

import cn.bps.mms.entity.Privilege;
import cn.bps.mms.entity.Role;
import cn.bps.mms.entity.RoleHasPrivilege;
import cn.bps.mms.mapper.RoleHasPrivilegeMapper;
import cn.bps.mms.service.PrivilegeService;
import cn.bps.mms.service.RoleHasPrivilegeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * <p>
 * 角色所拥有的的权限 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-07-01
 */
@Service
public class RoleHasPrivilegeServiceImpl extends ServiceImpl<RoleHasPrivilegeMapper, RoleHasPrivilege> implements RoleHasPrivilegeService {

    @Resource
    private PrivilegeService privilegeService;

    @Override
    public Privilege getMenuPrivilege(Role role) {

        QueryWrapper<RoleHasPrivilege> wrapper = new QueryWrapper<>();
        wrapper
                .eq("role_id",role.getId())
                .eq("available", true);
        List<RoleHasPrivilege> roleHasPrivileges = this.list(wrapper);
        if(roleHasPrivileges.isEmpty() == false){
            Optional<Privilege> optional = roleHasPrivileges.stream()
                    .map(e -> privilegeService.getById(e.getPrivilegeId()))
                    .filter(e -> Objects.equals("menu", e.getType())).findFirst();
            return optional.isPresent() ? optional.get() : null;
        }
        return null;
    }
}
