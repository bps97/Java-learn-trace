package cn.bps.controller;


import cn.bps.pojo.ScrollAd;
import cn.bps.service.ScrollAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/ad")
public class AdminAdController {


    @Autowired
    private ScrollAdService scrollAdService;

    @RequestMapping("")
    public String showUserView(Model model){

        List<ScrollAd> ads = scrollAdService.getAdObjectList();

        model.addAttribute("ads",ads);


        return "/admin/ad/ad";
    }


    @RequestMapping("/ad.do")
    @ResponseBody
    public ScrollAd ajaxGetAd(@RequestParam("adId")int id){

        return scrollAdService.getAdById(id);

    }

    @RequestMapping(value = "/edit.do")
    @ResponseBody
    public ScrollAd ajaxEditAd(@ModelAttribute ScrollAd scrollAd){


        return  scrollAdService.updateScrollAd(scrollAd);
    }

    @RequestMapping(value = "/del.do")
    @ResponseBody
    public Integer ajaxDelAd(@ModelAttribute ScrollAd scrollAd){

        return scrollAdService.removeScrollAd(scrollAd);

    }


    @RequestMapping(value = "/add.do")
    public String addScrollAd(@ModelAttribute ScrollAd scrollAd){

        return scrollAdService.addScrollad(scrollAd);

    }


}
