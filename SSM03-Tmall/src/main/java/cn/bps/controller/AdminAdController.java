package cn.bps.controller;


import cn.bps.pojo.ScrollAd;
import cn.bps.service.ScrollAdService;
import cn.bps.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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


    @RequestMapping(value = "/add")
    public String showAddView(Model model,
                              @RequestParam(defaultValue = "") String link,
                              @RequestParam(defaultValue = "") String text){
        model.addAttribute("scrollAd",new ScrollAd());
        model.addAttribute("link",link);
        model.addAttribute("text",text);
        return "/admin/ad/adAdd";
    }


    @RequestMapping(value = "/add/post")
    public String addScrollAd(@ModelAttribute ScrollAd scrollAd,
                              @RequestParam MultipartFile image,
                              HttpServletRequest request,
                              RedirectAttributes redirectAttributes){

        if(image !=null){

            String text = image.getOriginalFilename();
            String suffix = Util.matchSuffix(text);
            String fileName = Util.generatorRandomCode() + suffix;
            String filePath = "/img/ad/" + fileName;
            try {
                File file = new File(request.getServletContext().getRealPath("/WEB-INF/img/ad/"), fileName);
                if (!file.exists()) {
                    file.mkdir();
                }
                image.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            scrollAd.setLink(filePath);

        }

        if(scrollAdService.addNewScrollAd(scrollAd)>0)
            return "redirect:/admin/ad";


        redirectAttributes.addAttribute("link",scrollAd.getLink());
        redirectAttributes.addAttribute("text",scrollAd.getText());
        return "redirect:/admin/ad/add";

    }


}
