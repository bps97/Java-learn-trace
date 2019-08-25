package cn.bps.controller;


import cn.bps.entity.User;
import cn.bps.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/findUser")
    public String findUser(Model model){
        int id = 2;
        User user = this.userService.findUserById(id);
        model.addAttribute("user",user);
        return "index";
    }

}
