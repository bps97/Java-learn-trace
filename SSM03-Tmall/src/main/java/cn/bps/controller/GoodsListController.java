package cn.bps.controller;

import cn.bps.pojo.ConcreteFilter;
import cn.bps.pojo.FilterCase;
import cn.bps.pojo.Product;
import cn.bps.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class GoodsListController {

    @Autowired
    private FilterCaseService filterCaseService;

    @Autowired
    private ConcreteFilterService concreteFilterService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductBindFilterService productBindFilterService;

    @Autowired
    private ProductImageService productImageService;


    @RequestMapping(value = "/goods")
    public String list(Model model){

        List<FilterCase> list = filterCaseService.getFilterList();
        model.addAttribute("filterCase",list);

        List<Integer> filterIdList = filterCaseService.getFilterIdList();
        Map<Integer, List<ConcreteFilter>> map = concreteFilterService.getFilterMap(filterIdList);
        model.addAttribute("filterMap",map);


        Set<Integer> set = productBindFilterService.getProductIdSet(null);
        List<Product> products = productService.getProductListByFilter(set);
        model.addAttribute("products",products);


        Map<Integer, String> urlMap = productImageService.getImageUrl(products);
        model.addAttribute("urlMap",urlMap);

        return "goods";
    }


    @RequestMapping(value = "/goods/{index_none_header}")
    public String listGoods(@RequestParam(defaultValue = "")String index_none_header,
                            Model model){

        Set<Integer> set = productBindFilterService.getProductIdSet(null);

        List<Product> products = productService.getProductListByFilter(set);
        model.addAttribute("products",products);


        return "/goods";
    }


    @RequestMapping(value = "/showGoods.do",method = RequestMethod.GET)
    @ResponseBody
    public String[] listGoodsAjax(@RequestParam()String[] fCases){

        if(fCases[0] == "全部"){
            return null;
        }else{
            Set<Integer> set = concreteFilterService.getFilterIdByValues(fCases);
            productBindFilterService.getProductIdSet(set);
        }

        return fCases;
    }

}
