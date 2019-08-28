package cn.bps.controller;


import cn.bps.pojo.Category;
import cn.bps.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DemoController {


    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "index")
    public String showdemo(Model model){


        //获取十个分组
        List<List<Category>> lists = categoryService.getCategories(10);


        model.addAttribute("categorieslist", lists);

        return "index";


    }


    @RequestMapping(value = "mobile")
    public ModelAndView showmobile(){ return new ModelAndView("mobile"); }
}
