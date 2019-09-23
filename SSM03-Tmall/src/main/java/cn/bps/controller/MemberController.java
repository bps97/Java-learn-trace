package cn.bps.controller;

import cn.bps.pojo.User;
import cn.bps.service.ShoppingCartService;
import cn.bps.service.UserService;
import cn.bps.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.sql.Date;


@Controller
public class MemberController {

    @Autowired
    private UserService userService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

	@RequestMapping(value = "/register")
    public String register(){
        return "register";
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

	@RequestMapping(value = "/userInfo.do")
    @ResponseBody
    public User getUserInfo(@RequestParam("userId") int id)
    {
        return userService.getUserById(id);
    }

    /*登录*/
    /* 这里的逻辑是先通过ajax尝试登录，如果登录成功了就提交表单 */
    @RequestMapping(value = "/checkLogin.do")
    @ResponseBody
    public Integer postLogin(@RequestParam("loginNumber") String loginNumber,
                            @RequestParam("password") String password)
    {

        User user1 = userService.getUserByPhone(loginNumber);
        User user2=  userService.getUserByEmail(loginNumber);

        if(user1!=null && user1.getPassword().equals(password)  || user2!=null && user2.getPassword().equals(password)){
            return user1.getId();
        }

        return 0;
    }

	@RequestMapping(value = "/postLogin")
    public String postLogin(@RequestParam(value = "hiddenName") int id,
                            HttpSession session){

        User user = userService.getUserById(id);

        session.setAttribute("username",user.getName());
        session.setAttribute("userId",user.getId());
        session.setAttribute("shoppingCartSize",shoppingCartService.countProductItem(user.getId()));

        return "redirect:/index";
    }


    /*注册*/
    @RequestMapping(value = "/checkPhone.do")
    @ResponseBody
    public Integer checkName(@RequestParam("phone")String phone)
    {
        User user = userService.getUserByPhone(phone);

        if(user!=null) {
            return 0;
        }
        return 1;
    }

	@RequestMapping(value = "/postReg.do")
    @ResponseBody
    public Integer postRegister(@RequestParam("password") String password,
                               @RequestParam("phone") String phone,
                               HttpSession session)
    {
        User user = new User();
        user.setPassword(password);
        user.setPhone(phone);
        user.setName(Util.generatorRandomCode());

        if(userService.InsertOne(user) == 1){
            session.setAttribute("username",user.getName());
            session.setAttribute("userId",user.getId());
            return 1;
        }
        return 0;
    }
}
