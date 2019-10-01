package cn.bps.controller;


import cn.bps.pojo.Category;
import cn.bps.pojo.SubCategory;
import cn.bps.service.CategoryService;


import cn.bps.service.ScrollAdService;
import cn.bps.service.SubCategorySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategorySerivce subCategorySerivce;

    @Autowired
    private ScrollAdService scrollAdService;
    @RequestMapping(value = "/test")
    public String test(){
        return "base";
    }

	@RequestMapping(value = {"/index","/"})
    public String showDemo(Model model){


        //获取十个分组

        List<List<Category>> categoryGroup = categoryService.getAllCategory(12);
        model.addAttribute("categoryGroup", categoryGroup);

        Map<Integer,List<SubCategory>> con = subCategorySerivce.getCategoryProduct();
        model.addAttribute("categoryDict",con);


        List<String> ads = scrollAdService.getAds();
        model.addAttribute("ads",ads);


        return "index";


    }

	@RequestMapping(value = "/mobile")
    public ModelAndView showMobile(){ return new ModelAndView("mobile"); }




}
