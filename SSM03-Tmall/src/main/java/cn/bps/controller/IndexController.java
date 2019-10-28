package cn.bps.controller;


import cn.bps.pojo.Category;
import cn.bps.pojo.CategoryLogo;
import cn.bps.pojo.SubCategory;
import cn.bps.service.CategoryLogoService;
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

    @Autowired
    private CategoryLogoService categoryLogoService;

    @RequestMapping(value = "/test")
    public String test(){
        return "base";
    }

	@RequestMapping(value = {"/index","/"})
    public String showDemo(Model model){


        //获取十个分组

        model.addAttribute("categoryGroup", categoryService.getAllCategory(10));

        model.addAttribute("categoryLogo",categoryLogoService.getCategoryLogoMap());

        model.addAttribute("categoryDict",subCategorySerivce.getCategoryProduct());

        model.addAttribute("ads", scrollAdService.getAds());


        return "index";


    }

	@RequestMapping(value = "/mobile")
    public ModelAndView showMobile(){ return new ModelAndView("mobile"); }




}
