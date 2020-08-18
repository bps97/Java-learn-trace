package cn.bps.mms.service.impl;

import cn.bps.mms.model.pojo.Role;
import cn.bps.mms.mapper.RoleMapper;
import cn.bps.mms.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public String getDefaultRoleId() {
        return "default_role_id";
    }

    @Override
    public String getRoleName(String roleId) {
        return this.getById(roleId).getName();
    }


}
