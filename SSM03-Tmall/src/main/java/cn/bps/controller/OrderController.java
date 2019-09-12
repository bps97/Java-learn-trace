package cn.bps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {


    @RequestMapping(value = "/order")
    public String generatorOrder(@RequestParam()String[] items){

        return "/pay";
    }

}
