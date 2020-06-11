package cn.bps.mms.service;

import cn.bps.enums.CompositeMode;
import cn.bps.mms.entity.Authentication;
import cn.bps.mms.vo.AuthenticationVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 账户基本信息 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
public interface AuthenticationService extends IService<Authentication> {

    List<AuthenticationVo> listAuthentications();

    List<Authentication> rootsAuthentications();

    List<AuthenticationVo> listAllAuthentication();

    List<Authentication> getChildren(String parentId);
}
