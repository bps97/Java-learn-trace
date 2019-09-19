package cn.bps.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/base")
    public String showBaseView(){
        return "/admin/base";
    }


    @RequestMapping(value = {"","/index"})
    public String showIndexView(){
        return "/admin/index";
    }

//    @RequestMapping("/demo")
//    public String showDemoView(){
//        return "/admin/demo";
//    }

}
