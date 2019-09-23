package cn.bps.controller;


import cn.bps.pojo.Administrator;
import cn.bps.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdministratorService administratorService;

    @RequestMapping("/base")
    public String showBaseView(){
        return "/admin/base";
    }

	@RequestMapping(value = {"","/index"})
    public String showIndexView(@ModelAttribute("sessionUsername")String username){

        if(username.equals("")) return "redirect:/admin/login";

        return "/admin/index";
    }

	@RequestMapping("/login")
    public String showLoginView(Model model,
                                @RequestParam(value = "message",defaultValue = "")String message,
                                @RequestParam(value = "username",defaultValue = "")String username){
        model.addAttribute("administrator",new Administrator());//这个是表单标签库前台command必须要的。
        model.addAttribute("message",message);
        model.addAttribute("username",username);

        return "/admin/login";

    }

	@RequestMapping("/login/post")
    public String postLoginView(@ModelAttribute Administrator administrator,
                                HttpSession session,
                                RedirectAttributes redirectAttributes){

        if(administratorService.check(administrator)){
            session.setAttribute("username",administrator.getUsername());
            return "redirect:/admin";
        }
        redirectAttributes.addAttribute("message","用户名与密码不匹配!");
        redirectAttributes.addAttribute("username",administrator.getUsername());//用户输入的账号
        return "redirect: /admin/login";

    }

	@RequestMapping(value = {"/logout/post","/switch/post"})
    public String postLogoutView(HttpSession session,
                                 RedirectAttributes redirectAttributes,
                                 @ModelAttribute("sessionUsername")String username){

        if(username.equals("")) return "redirect:/admin/login";
        redirectAttributes.addAttribute("username",username);
        session.removeAttribute("username");
        return "redirect:/admin/login";
    }

    //验证账号session
    @ModelAttribute("sessionUsername")
    public String BeforeAdminController(HttpSession session){
        String username = (String)session.getAttribute("username");
        if(username!=null){
            return username;
        }
        return "";
    }

}
