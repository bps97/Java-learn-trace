package cn.bps.controller;

import cn.bps.pojo.ConcreteFilter;
import cn.bps.pojo.FilterCase;
import cn.bps.pojo.Product;
import cn.bps.service.*;
import cn.bps.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RequestMapping(value = "/good")
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

    @RequestMapping(value = "{id}")
    public String showgood(@PathVariable(value = "id")int id,
                           Model model){

        Product product = productService.getProductById(id);

        model.addAttribute("product",product);

        String imgeUrl = productImageService.getImageUrl(product.getId());
        model.addAttribute("imgUrl",imgeUrl);

        return "shopInfo";
    }


    @RequestMapping(value = {"/list",""},method = RequestMethod.GET)
    public String listGoods(@RequestParam(value = "caseList",defaultValue = "")String caseList,
                                @RequestParam(value = "start",defaultValue = "0")int start,
                                @RequestParam(value = "step",defaultValue = "20")int step,
                                Model model){


        /* 筛选条件 */
        List<FilterCase> list = filterCaseService.getFilterList();//获取筛选情况分类
        model.addAttribute("filterCase",list);
        List<Integer> filterIdList = filterCaseService.getFilterIdList();//获取筛选情况的字典表
        Map<Integer, List<ConcreteFilter>> map = concreteFilterService.getFilterMap(filterIdList);
        model.addAttribute("filterMap",map);



        /*分页*/

        Page page = new Page(start,step);
        model.addAttribute("page",page);



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
//        List<Product> products = productService.getProductListByProductIdSet(productIdSet);
        List<Product> products = productService.rowBoundsProduct(productIdSet,page.getStart(),page.getStep());

        model.addAttribute("products",products);
        Map<Integer, String> urlMap = productImageService.getImageUrls(products);//获取产品图片链接
        model.addAttribute("urlMap",urlMap);



        return "/goods";

    }

}
