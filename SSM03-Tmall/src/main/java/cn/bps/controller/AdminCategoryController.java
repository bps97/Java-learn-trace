package cn.bps.controller;


import cn.bps.pojo.Category;
import cn.bps.pojo.SubCategory;
import cn.bps.service.CategoryService;
import cn.bps.service.SubCategorySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategorySerivce subCategorySerivce;


    @RequestMapping("")
    public String showCategoryView(Model model){
        Map<Category, List<SubCategory>> categoryMap = subCategorySerivce.getCategoryAndSubCategory();

        model.addAttribute("categoryMap",categoryMap);


        return "/admin/category/category";
    }

}
