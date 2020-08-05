package cn.bps.mms.service;

import cn.bps.mms.model.pojo.Privilege;
import cn.bps.mms.model.pojo.Role;
import cn.bps.mms.model.pojo.RoleHasPrivilege;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色所拥有的的权限 服务类
 * </p>
 *
 * @author bps
 * @since 2020-07-01
 */
public interface RoleHasPrivilegeService extends IService<RoleHasPrivilege> {

    Privilege getMenuPrivilege(Role role);
    
}
