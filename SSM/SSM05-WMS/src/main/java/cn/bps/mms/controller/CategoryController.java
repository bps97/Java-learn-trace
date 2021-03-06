package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.model.vo.KeyValue;
import cn.bps.mms.model.pojo.Category;
import cn.bps.mms.service.CategoryService;
import cn.bps.mms.model.vo.CategoryTreeVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 分类 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@Api(tags = "分类")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 获取多级分类菜单
     * @return
     */
    @GetMapping("/menus")
    public Ret<List<CategoryTreeVo>> menus(){
        return Ret.ok(categoryService.menuCategories());
    }

    /**
     * 获取分类列表
     * @param page
     * @return
     */
    @GetMapping("/list")
    public Ret<IPage<CategoryTreeVo>> pageCategories(Page<Category> page, String specialLineId){
        return Ret.ok(categoryService.pageCategories(page,specialLineId));
    }

    /**
     * 获取专业线列表
     * @return
     */
    @GetMapping("/specialLine")
    public Ret<List<KeyValue>> listSpecialLines(){
        return Ret.ok(categoryService.listSpecialLines());
    }

    /**
     * 修改有效性
     * @param id
     * @param available
     * @return
     */
    @PutMapping("/{id}/available/{available}")
    public Ret changeAvailability(@PathVariable String id, @PathVariable Boolean available){
        return Ret.ok(()->categoryService.changeAvailable(id, available));
    }

    /**
     * 根据ID获取分类信息实例
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Ret<CategoryTreeVo> getById(@PathVariable String id) {
        return Ret.ok(categoryService.getVoById(id));
    }

    /**
     * 移除指定实例
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Ret remove(@PathVariable String id) {
        return Ret.ok(()->categoryService.removeById(id));
    }

    /**
     * 修改指定实例
     * @param id
     * @param category
     * @return
     */
    @PutMapping("/{id}")
    public Ret modify(@PathVariable String id, @RequestBody Category category) {
        return Ret.ok(()->categoryService.updateById(id, category));
    }

    /**
     * 添加实例
     * @param category
     * @return
     */
    @PostMapping("/add")
    public Ret add(@RequestBody Category category){
        return Ret.create(()->categoryService.addCategory(category));
    }
}

