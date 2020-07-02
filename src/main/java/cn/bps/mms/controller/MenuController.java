package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.domain.vo.MenuItemVo;
import cn.bps.mms.entity.Menu;
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

    @GetMapping("/menus")
    public Ret<List<MenuItemVo>> listAuthentications(@RequestHeader String token){
        return Ret.ok(menuService.listAuthentications(token));
    }

    @GetMapping("")
    public Ret<IPage<Menu>> pageAuthentications(Page<Menu> page) {
        return Ret.ok(menuService.pageAuthentications(page));
    }
}

