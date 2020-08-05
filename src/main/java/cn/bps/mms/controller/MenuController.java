package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.model.vo.MenuItemVo;
import cn.bps.mms.model.pojo.Menu;
import cn.bps.mms.service.MenuService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 显示菜单
     * @param token
     * @return
     */
    @GetMapping("/menus")
    public Ret<List<MenuItemVo>> showMenus(@RequestHeader String token){
        return Ret.ok(menuService.listAuthentications(token));
    }

    /**
     * 分页展示菜单项
     * @param page
     * @return
     */
    @GetMapping("")
    public Ret<IPage<Menu>> pageMenus(Page<Menu> page) {
        return Ret.ok(menuService.pageAuthentications(page));
    }
}

