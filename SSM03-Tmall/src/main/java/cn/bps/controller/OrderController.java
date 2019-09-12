package cn.bps.controller;

import cn.bps.pojo.Product;
import cn.bps.pojo.ShoppingCart;
import cn.bps.service.OrderService;
import cn.bps.service.ProductImageService;
import cn.bps.service.ProductService;
import cn.bps.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/order")
    public String generatorOrder(@RequestParam(defaultValue = "0")Integer[] items,
                                 Model model){
        if(items[0] == 0){



            return "1";
        }
        List<Integer> itemlist = Arrays.asList(items);

        List<ShoppingCart> productItems =  orderService.getProductItemByItemIds(itemlist);
        model.addAttribute("productItems",productItems);

        Map<Integer, Product> productMap = productService.getProductMapByShoppingCartList(productItems);
        model.addAttribute("productMap",productMap);

        Map<Integer, String> urls = productImageService.getImageUrls(productMap.values());
        model.addAttribute("images",urls);

        Float totalCost = shoppingCartService.countTotalPrice(itemlist);
        model.addAttribute("totalCost",totalCost);



        return "/pay";
    }

}
