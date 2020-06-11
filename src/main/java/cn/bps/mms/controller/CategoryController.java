package cn.bps.mms.controller;


import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.domain.PageRequest;
import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.Category;
import cn.bps.mms.service.CategoryService;
import cn.bps.mms.vo.CategoryVo;
import org.springframework.web.bind.annotation.*;

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
        return Ret.ok(categoryService.listCategories(true));
    }

    @GetMapping("")
    public Ret<Page<CategoryVo>> Categories(PageRequest request, Integer level){
        return Ret.ok(categoryService.pageCategories(request, level));
    }

    @PutMapping("/{id}/available/{available}")
    public Ret changeCategoryAvailability(@PathVariable String id,@PathVariable Boolean available){
        return Ret.ok(()->categoryService.changeAvailable(id, available));
    }

    @GetMapping("/{id}")
    public Ret<CategoryVo> getCategoryInfo(@PathVariable String id) {
        return Ret.ok(categoryService.getVoById(id));
    }

    @DeleteMapping("/{id}")
    public Ret deleteUser(@PathVariable String id) {
        return Ret.ok(()->categoryService.removeById(id));
    }

//    @PutMapping("/{id}")
//    public Ret modifyUserInfo(@PathVariable String id, @RequestBody CategoryVo account) {
//        return Ret.ok(()->categoryService.updateById(id, account));
//    }

}

