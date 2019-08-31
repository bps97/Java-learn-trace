package cn.bps.controller;

import cn.bps.pojo.User;
import cn.bps.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class MemberController {

    @Autowired
    private UserServiceImp userServiceImp;



    @RequestMapping(value = "/login")
    public String login(){

        return "login";
    }


    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/postLogin.do")
    @ResponseBody
    public String postLogin(@RequestParam("loginNumber") String loginNumber,
                            @RequestParam("password") String password){

        User user1 = userServiceImp.getUserByPhone(loginNumber);
        User user2=  userServiceImp.getUserByEmail(loginNumber);

        if(user1!=null && user1.getPassword().equals(password)){
            return user1.getId().toString();
        }
        if(user2!=null && user2.getPassword().equals(password)){

            return user1.getId().toString();
        }

        return "0";
    }

    @RequestMapping(value = "/postLogin")
    public String postLogin(@RequestParam(value = "hiddenName") int id,HttpSession session){
        User user = userServiceImp.getUserById(id);
        String username = user.getName();
        if(username == null) username="游客，请设置用户名";
        session.setAttribute("username",username);
        session.setAttribute("userId",user.getId());
        return "redirect:/index";
    }

    @RequestMapping(value = "/mySpace")
    public String userSpace(HttpSession session, Model model){
        Object id = (session.getAttribute("userId"));
        if(id == null)
            return "redirect:/login";
        User user = userServiceImp.getUserById((int)id);
        model.addAttribute("user",user);
        return "mySpace";
    }

    @RequestMapping(value = "/postSubmitInfo")
    public String UpdateUserInfo(@RequestParam("name")String name,
                                 @RequestParam("email")String email,
                                 @RequestParam("phone")String phone,
                                 HttpSession session){
        User user = userServiceImp.getUserByPhone(phone);
        user.setEmail(email);
        user.setName(name);
        session.setAttribute("username", name);
        session.setAttribute("userId",user.getId());

        userServiceImp.updateInfo(user);

        return "redirect:/mySpace";
    }


    @RequestMapping(value = "/postReg.do")
    @ResponseBody
    public String postRegister(@RequestParam("password") String password,
                               @RequestParam("phone") String phone,
                               HttpSession session){
        User user = new User();
        user.setPassword(password);
        user.setPhone(phone);

        if(userServiceImp.InsertOne(user) == 1){
            session.setAttribute("username",user.getName());
            session.setAttribute("userId",user.getId());
            return "1";
        }else{
            return "0";
        }



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



    @RequestMapping(value = "/userInfo.do")
    public @ResponseBody User getUserInfo(@RequestParam("userId") int id){
        return userServiceImp.getUserById(id);
    }


}
