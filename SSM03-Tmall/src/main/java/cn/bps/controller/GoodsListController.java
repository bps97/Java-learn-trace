package cn.bps.controller;


import cn.bps.pojo.FilterCase;
import cn.bps.service.FilterCaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GoodsListController {

    @Autowired
    private FilterCaseServiceImp filterCaseServiceImp;

    @RequestMapping(value = "/goods")
    public String list(Model model){
        List<FilterCase> list = filterCaseServiceImp.getFilterList();
        model.addAttribute("filterCase",list);
        return "goods";
    }

}
