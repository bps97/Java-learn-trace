package cn.bps.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

@Controller
public class JspController {

    @RequestMapping("jsp")
    public String jsp(Model m){
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "demo";
    }

}
