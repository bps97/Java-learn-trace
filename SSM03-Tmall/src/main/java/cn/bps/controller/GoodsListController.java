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

import java.util.*;

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


//    @RequestMapping(value = "/goods")
//    public String list(Model model){
//
//        List<FilterCase> list = filterCaseService.getFilterList();
//        model.addAttribute("filterCase",list);
//
//        List<Integer> filterIdList = filterCaseService.getFilterIdList();
//        Map<Integer, List<ConcreteFilter>> map = concreteFilterService.getFilterMap(filterIdList);
//        model.addAttribute("filterMap",map);
//
//
//        Set<Integer> set = productBindFilterService.getProductIdSet();
//        List<Product> products = productService.getProductListByProductIdSet(set);
//        model.addAttribute("products",products);
//
//
//        Map<Integer, String> urlMap = productImageService.getImageUrl(products);
//        model.addAttribute("urlMap",urlMap);
//
//        return "goods";
//    }


    @RequestMapping(value = "/postCases/")
    public String listGoods(@RequestParam(defaultValue = "")String fCases,
                            Model model){





        return "/goods";
    }


    @RequestMapping(value = "/goods",method = RequestMethod.GET)
    public String listGoodsAjax(@RequestParam(value = "caseList",defaultValue = "")String caseList,
                                Model model){


        /* 筛选条件 */
        List<FilterCase> list = filterCaseService.getFilterList();//获取筛选情况分类
        model.addAttribute("filterCase",list);
        List<Integer> filterIdList = filterCaseService.getFilterIdList();//获取筛选情况的字典表
        Map<Integer, List<ConcreteFilter>> map = concreteFilterService.getFilterMap(filterIdList);
        model.addAttribute("filterMap",map);



        /* 产品 */
        Set<Integer> productIdSet = null;
        if(caseList.equals("") || caseList.equals("全部,全部,全部,全部,全部,全部") ){
            productIdSet = productBindFilterService.getProductIdSet();

        }else{

        String[] temp = caseList.split(",");
        Set<Integer> filterIdSet = concreteFilterService.getFilterIdByValues(temp);//获取筛选条件
        productIdSet = productBindFilterService.getProductIdSet(filterIdSet);//根据筛选条件获取产品id
        model.addAttribute("filterCases",concreteFilterService.getFilterIds(filterIdSet));



        }
        List<Product> products = productService.getProductListByProductIdSet(productIdSet);
        model.addAttribute("products",products);
        Map<Integer, String> urlMap = productImageService.getImageUrl(products);//获取产品图片链接
        model.addAttribute("urlMap",urlMap);








        return "/goods";

    }

}
