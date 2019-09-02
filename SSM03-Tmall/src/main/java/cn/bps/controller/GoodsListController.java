package cn.bps.controller;

import cn.bps.pojo.ConcreteFilter;
import cn.bps.pojo.FilterCase;
import cn.bps.pojo.Product;
import cn.bps.pojo.ProductBindFilter;
import cn.bps.service.ConcreteFilterService;
import cn.bps.service.FilterCaseService;
import cn.bps.service.ProductBindFilterService;
import cn.bps.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/goods")
    public String list(Model model){

        List<FilterCase> list = filterCaseService.getFilterList();
        model.addAttribute("filterCase",list);
        Map<Integer, List<ConcreteFilter>> map = concreteFilterService.getFilterMap();
        model.addAttribute("filterMap",map);


        Set<Integer> set = productBindFilterService.getProductIdSet();
        List<Product> products = productService.getProductListByFilter(set);
        model.addAttribute("products",products);

        return "goods";
    }


    @RequestMapping(value = "/goods/{index_none_header}")
    public String listGoods(@RequestParam(defaultValue = "")String index_none_header,
                            Model model){

        Set<Integer> set = productBindFilterService.getProductIdSet();

        List<Product> products = productService.getProductListByFilter(set);
        model.addAttribute("products",products);


        return "/goods";
    }

}
