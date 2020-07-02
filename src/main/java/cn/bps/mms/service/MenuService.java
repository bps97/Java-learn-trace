package cn.bps.mms.service;

import cn.bps.mms.entity.Menu;
import cn.bps.mms.domain.vo.MenuItemVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
public interface MenuService extends IService<Menu> {

    List<MenuItemVo> listAuthentications(String token);

    List<Menu> rootsAuthentications();

    List<MenuItemVo> listAllAuthentication();

    List<Menu> getChildren(String parentId);

    IPage<Menu> pageAuthentications(Page<Menu> page);
}
