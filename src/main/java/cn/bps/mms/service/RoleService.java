package cn.bps.mms.service;

import cn.bps.mms.model.pojo.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
public interface RoleService extends IService<Role> {

    String getDefaultRoleId();

    String getRoleName(String roleId);

}
