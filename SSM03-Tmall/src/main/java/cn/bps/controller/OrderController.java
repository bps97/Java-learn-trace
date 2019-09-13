package cn.bps.controller;

import cn.bps.pojo.AdministrativeArea;
import cn.bps.pojo.Product;
import cn.bps.pojo.ProductItem;
import cn.bps.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RequestMapping("/order")
@Controller
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private AdministrativeAreaService administrativeAreaService;


    @RequestMapping(value = "/post")
    public String submitOrder(){





        return "succeed";
    }

    @RequestMapping(value = "/addArea.do")
    @ResponseBody
    public Map<String, String> ajaxGetAdministrativeArea(@RequestParam(defaultValue = "0")String parentCode){
        List<AdministrativeArea> administrativeAreas = administrativeAreaService.getChildrenCities(parentCode);

        return administrativeAreaService.toTuple(administrativeAreas);
    }


    @RequestMapping(value = "")
    public String generatorOrder(@RequestParam(defaultValue = "0")Integer[] items,
                                 Model model,HttpSession session){




        if(session.getAttribute("userId") == null)
            return "0";

        if(items[0] == 0){
            return  "0";
        }

        int userId = (Integer)session.getAttribute("userId");


        List<Integer> itemList = Arrays.asList(items);

        List<ProductItem> productItems =  shoppingCartService.getShoppingCartByIds(itemList);
        model.addAttribute("productItems",productItems);

        Map<Integer, Product> productMap = productService.getProductMapByShoppingCartList(productItems);
        model.addAttribute("productMap",productMap);

        Map<Integer, String> urls = productImageService.getImageUrls(productMap.values());
        model.addAttribute("images",urls);

        List<AdministrativeArea> provinces = administrativeAreaService.getProvinces();
        model.addAttribute("province",provinces);

        List<AdministrativeArea> prefectures = administrativeAreaService.getChildrenCities(provinces.get(0).getCode());
        model.addAttribute("prefectures",prefectures);

        List<AdministrativeArea> counties = administrativeAreaService.getChildrenCities(prefectures.get(0).getCode());
        model.addAttribute("counties",counties);


//        Float totalCost = shoppingCartService.countTotalPrice(itemList);
//        model.addAttribute("totalCost",totalCost);


        if(orderService.generatorOrder(userId)!=0)
            return "/order";

        return "0";

    }




}
