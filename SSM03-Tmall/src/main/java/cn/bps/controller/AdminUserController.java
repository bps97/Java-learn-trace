package cn.bps.controller;


import cn.bps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {


    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String showUserView(){


        return "/admin/user/user";
    }


}
