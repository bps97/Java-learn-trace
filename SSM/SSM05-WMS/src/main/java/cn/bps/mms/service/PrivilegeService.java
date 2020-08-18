package cn.bps.mms.service;

import cn.bps.mms.model.pojo.Privilege;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author bps
 * @since 2020-07-01
 */
public interface PrivilegeService extends IService<Privilege> {


    List<Privilege> listPrivileges();
}
