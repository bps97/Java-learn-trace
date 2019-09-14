package cn.bps.controller;

import cn.bps.pojo.Product;
import cn.bps.pojo.ProductItem;
import cn.bps.service.ProductImageService;
import cn.bps.service.ProductService;
import cn.bps.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/shop")
public class ShoppingCartController {


    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductImageService productImageService;





    @RequestMapping(value = {"","/"})
    public String showShopCart(HttpSession session,
                               Model model){


        if(session.getAttribute("userId") == null){
            return "redirect:/login";
        }
        int userId = (Integer)session.getAttribute("userId");



        List<ProductItem> productItems = shoppingCartService.getShoppingCartProductByUserId(userId);
        model.addAttribute("shoppingCarts", productItems);

        Map<Integer, Product> productMap = productService.getProductMapByShoppingCartList(productItems);
        model.addAttribute("productMap",productMap);

        Map<Integer, String> urls = productImageService.getImageUrls(productMap.values());
        model.addAttribute("images",urls);

//        Float totalPrice = shoppingCartService.countTotalPrice(userId);
//        model.addAttribute("totalPrice",totalPrice);

        return "shoppingCart";
    }



    @RequestMapping(value = "/add.do/{id}")
    @ResponseBody
    public Integer ajaxAddShoppingCart(@PathVariable(value = "id")int productId,
                                       @RequestParam(value = "quality",defaultValue = "1") int quality,
                                       HttpSession session){


        if(session.getAttribute("userId") == null)
            return 0;

        Integer userId = (Integer) session.getAttribute("userId");
        return shoppingCartService.insertOne(productId, userId, quality);

    }


    @RequestMapping(value = "/del.do")
    @ResponseBody
    public Integer ajaxDelShoppingCart(HttpSession session,
                                       @RequestParam(value = "itemId",defaultValue = "0") int itemId){


        if(session.getAttribute("userId") == null)
            return 0;

        Integer userId = (Integer) session.getAttribute("userId");
        return shoppingCartService.removeOne(itemId);
    }


    @RequestMapping(value = "/update.do")
    @ResponseBody
    public Integer ajaxAddShoppingCart(HttpSession session,
                                       @RequestParam(value = "itemId",defaultValue = "0") int itemId,
                                       @RequestParam(value = "quality",defaultValue = "1") int quality){


        if(session.getAttribute("userId") == null)
            return 0;

        Integer userId = (Integer) session.getAttribute("userId");
        return shoppingCartService.updateItemQualityByItemId(itemId,quality);


    }


    @RequestMapping(value = "/post/{id}")
    public String addTOShoppingCart(@PathVariable(value = "id")int productId,
                                    HttpSession session,
                                    @RequestParam(value = "quality",defaultValue = "1") int quality){
        if(session.getAttribute("userId") == null){
            return "redirect:/login";
        }
        Integer userId = (Integer) session.getAttribute("userId");
        shoppingCartService.insertOne(productId, userId, quality);


        return "redirect:/shop";

    }





}
