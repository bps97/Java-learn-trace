package cn.bps.controller;

import cn.bps.pojo.User;
import cn.bps.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    private UserServiceImp userServiceImp;



    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }


    @RequestMapping(value = "register")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/logining" , method = RequestMethod.POST)
    public String postLogin(@RequestParam("loginName") String loginName,
                            @RequestParam("password") String password,
                            HttpSession session){

        User user1 = userServiceImp.getUserByPhone(loginName);
        User user2=  userServiceImp.getUserByEmail(loginName);

        if(user1!=null && user1.getPassword().equals(password)){
            String name = user1.getName();
            name = (name ==null)?"用户":name;

            return "redirect:/index";
        }
        if(user2!=null && user2.getPassword().equals(password)){
            return "redirect:/index";
        }

        return "redirect:/login";
    }


    @RequestMapping(value = "/registering")
    public String postRegister(@RequestParam("password") String password,
                               @RequestParam("phone") String phone){
        User user = new User();
        user.setPassword(password);
        user.setPhone(phone);
        userServiceImp.InsertOne(user);

        return "redirect:/index";

    }


    @RequestMapping(value = "/checkPhone.do")
    @ResponseBody
    public String checkName(@RequestParam("phone")String phone){
        User user = userServiceImp.getUserByPhone(phone);

        if(user!=null) {
            return "0";
        }

        return "1";
    }


}
