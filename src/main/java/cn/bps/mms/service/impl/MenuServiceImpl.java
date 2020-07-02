package cn.bps.mms.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.Menu;
import cn.bps.mms.entity.Privilege;
import cn.bps.mms.entity.Role;
import cn.bps.mms.mapper.MenuMapper;
import cn.bps.mms.service.MenuService;
import cn.bps.mms.domain.vo.MenuItemVo;
import cn.bps.mms.service.RoleHasPrivilegeService;
import cn.bps.mms.service.RoleService;
import cn.bps.security.server.service.TokenService;
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
 * 菜单 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private TokenService tokenService;

    @Resource
    private RoleService roleService;

    @Resource
    private RoleHasPrivilegeService roleHasPrivilegeService;

    @Override
    public List<MenuItemVo> listAuthentications(String token) {
        Account account = tokenService.getAccount(token);
        Role role = roleService.getById(account.getRoleId());
        Privilege privilege = roleHasPrivilegeService.getMenuPrivilege(role);
        Integer privilegeLevel = Objects.isNull(privilege) ? Integer.MAX_VALUE : privilege.getPrivilegeLevel();
        List<Menu> rootMenus = rootsAuthentications(privilegeLevel);
        List<MenuItemVo> listAuthentications = model2Vo(rootMenus);
        return listAuthentications;
    }


    @Override
    public List<Menu> rootsAuthentications() {
        return rootsAuthentications(0);
    }

    public List<Menu> rootsAuthentications(Integer privilegeLevel) {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available",true)
                .isNull("parent_id")
                .orderByAsc("portal_index")
                .ge("privilege_level", privilegeLevel);

        List<Menu> rootMenus = this.list(wrapper);

        if(Objects.isNull(rootMenus) || rootMenus.isEmpty()){
            throw new LocalBizServiceException(CustomizeExceptionCode.AUTHENTICATION_NOT_EXIST);
        }
        return rootMenus;
    }

    @Override
    public List<MenuItemVo> listAllAuthentication() {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .orderByAsc("portal_index");

        List<Menu> menus = this.list(wrapper);
        return model2Vo(menus);
    }


    @Override
    public List<Menu> getChildren(String parentId) {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("parent_id", parentId);
        List<Menu> menus = this.list(wrapper);
        return menus;
    }

    @Override
    public IPage<Menu> pageAuthentications(Page<Menu> page) {
        return menuMapper.selectPage(page,new QueryWrapper<>());
    }


    private List<MenuItemVo> model2Vo(List<Menu> rootMenus) {

        List<MenuItemVo> lists = Lists.newArrayList();

        for(Menu parent: rootMenus){
            List<Menu> children = getChildren(parent.getId());
            MenuItemVo vo = new MenuItemVo();
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
