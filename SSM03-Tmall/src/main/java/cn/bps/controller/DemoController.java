package cn.bps.controller;


import cn.bps.pojo.Category;
import cn.bps.pojo.CategoryDemo;
import cn.bps.service.CategoryDemoServiceImp;
import cn.bps.service.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DemoController {


    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @Autowired
    private CategoryDemoServiceImp categoryDemoServiceImp;

    @RequestMapping(value = "index")
    public String showdemo(Model model){


        //获取十个分组

        List<List<Category>> categoryGroup = categoryServiceImp.getCategories(10);



        model.addAttribute("categoryGroup", categoryGroup);


        return "index";


    }


    @RequestMapping(value = "mobile")
    public ModelAndView showmobile(){ return new ModelAndView("mobile"); }


    @RequestMapping(value = "/loadSubCategory.do")
    @ResponseBody
    public Model checkName(Model model){

        Map<Integer,List<CategoryDemo>> con = categoryDemoServiceImp.getCategoryProduct();
        model.addAttribute("categoryDict",con);




        return model;
    }

}
