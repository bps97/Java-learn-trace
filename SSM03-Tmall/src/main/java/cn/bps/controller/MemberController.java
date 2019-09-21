package cn.bps.controller;

import cn.bps.pojo.User;
import cn.bps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;


@Controller
public class MemberController {

    @Autowired
    private UserService userService;



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
                            @RequestParam("password") String password)
    {

        User user1 = userService.getUserByPhone(loginNumber);
        User user2=  userService.getUserByEmail(loginNumber);

        if(user1!=null && user1.getPassword().equals(password)){
            return user1.getId().toString();
        }
        if(user2!=null && user2.getPassword().equals(password)){

            return user1.getId().toString();
        }

        return "0";
    }

    @RequestMapping(value = "/postLogin")
    public String postLogin(@RequestParam(value = "hiddenName") int id,
                            HttpSession session){
        User user = userService.getUserById(id);
        String username = user.getName();
        if(username == null) username="游客，请设置用户名";
        session.setAttribute("username",username);
        session.setAttribute("userId",user.getId());
        return "redirect:/index";
    }

    @RequestMapping(value = "/space")
    public String userSpace(HttpSession session, Model model)
    {
        Object id = (session.getAttribute("userId"));
        if(id == null)
            return "redirect:/login";
        User user = userService.getUserById((int)id);
        model.addAttribute("user",user);
        return "space";
    }

    @RequestMapping(value = "/postSubmitInfo")
    public String UpdateUserInfo(@RequestParam(value = "name",required=false)String name,
                                 @RequestParam(value = "email",required=false)String email,
                                 @RequestParam(value = "phone")String phone,
                                 @RequestParam(value = "birthday", defaultValue = "1111-11-11") Date birthday,
                                 HttpSession session)
    {

        User user = userService.getUserByPhone(phone);

            user.setEmail(email);
            user.setName(name);

        if(!birthday.toString().equals("1111-11-11"))
            user.setBirthday(birthday);


        session.setAttribute("username", name);
        session.setAttribute("userId",user.getId());

        userService.updateInfo(user);

        return "redirect:/space";
    }


    @RequestMapping(value = "/postReg.do")
    @ResponseBody
    public String postRegister(@RequestParam("password") String password,
                               @RequestParam("phone") String phone,
                               HttpSession session)
    {
        User user = new User();
        user.setPassword(password);
        user.setPhone(phone);

        if(userService.InsertOne(user) == 1){
            session.setAttribute("username",user.getName());
            session.setAttribute("userId",user.getId());
            return "1";
        }else{
            return "0";
        }



    }


    @RequestMapping(value = "/checkPhone.do")
    @ResponseBody
    public String checkName(@RequestParam("phone")String phone)
    {
        User user = userService.getUserByPhone(phone);

        if(user!=null) {
            return "0";
        }

        return "1";
    }



    @RequestMapping(value = "/userInfo.do")
    @ResponseBody
    public User getUserInfo(@RequestParam("userId") int id)
    {
        return userService.getUserById(id);
    }


}
