package cn.bps.heam.controller;

import cn.bps.common.lang.domain.Ret;
import cn.bps.heam.domain.form.CategoryForm;
import cn.bps.heam.domain.result.CategoryResult;
import cn.bps.heam.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

/*    @GetMapping
    public Ret<Page<CategoryResult>> pageCategories(PageRequest pageRequest){
        return Ret.ok(categoryService.pageCategories(pageRequest));
    }*/

    @GetMapping
    public Ret<List<CategoryResult>> listCategories(){
        return Ret.ok(categoryService.listCategories());
    }

    @PostMapping
    public Ret addCategory(@RequestBody CategoryForm form){
        return Ret.create(()->categoryService.saveProductCategory(form.getName()));
    }

    @DeleteMapping("/{id}")
    public Ret removeCategory(@PathVariable String id){
        return Ret.ok(()->categoryService.removeProductCategory(id));
    }




}
