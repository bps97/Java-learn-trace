package cn.bps.mms.controller;


import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.domain.PageRequest;
import cn.bps.mms.service.CategoryService;
import cn.bps.mms.vo.CategoryVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 分类项 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/menus")
    public Ret<List<CategoryVo>> categoryMenus(){
        return Ret.ok(categoryService.listCategories());
    }

    @GetMapping("")
    public Ret<Page<CategoryVo>> Categories(PageRequest request, Integer level){
        return Ret.ok(categoryService.pageCategories(request, level));
    }

}

