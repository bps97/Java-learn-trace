package cn.bps.controller;

import cn.bps.pojo.Product;
import cn.bps.pojo.ShoppingCart;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class ShoppingCartController {


    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductImageService productImageService;



    @RequestMapping(value = "countTotal.do")
    @ResponseBody
    public Float countTotalPrice(Integer[] shopId){
        if(shopId.length==0){
            return 0f;
        }
        List<Integer> list = Arrays.asList(shopId);

        return shoppingCartService.countTotalPrice(list);
    }


    @RequestMapping(value = "/shoppingCart")
    public String showShopCart(HttpSession session,
                               Model model){


        if(session.getAttribute("userId") == null){
            return "redirect:/login";
        }
        int userId = (Integer)session.getAttribute("userId");



        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCartProductByUserId(userId);
        model.addAttribute("shoppingCarts", shoppingCarts);

        Map<Integer, Product> productMap = productService.getProductMapByShoppingCartList(shoppingCarts);
        model.addAttribute("productMap",productMap);

        Map<Integer, String> urls = productImageService.getImageUrls(productMap.values());
        model.addAttribute("images",urls);

//        Float totalPrice = shoppingCartService.countTotalPrice(userId);
//        model.addAttribute("totalPrice",totalPrice);

        return "shoppingCart";
    }



    @RequestMapping(value = "/addShoppingCart.do/{id}")
    @ResponseBody
    public String ajaxAddShoppingCart(@PathVariable(value = "id")int id,
                                      HttpSession session,
                                      @RequestParam(value = "quality",defaultValue = "1") int quality){


        if(session.getAttribute("userId") == null)
            return "0";


        int userId = (Integer)session.getAttribute("userId");

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProduct_id(id);
        shoppingCart.setQuality(quality);
        shoppingCart.setUser_id(userId);
        shoppingCartService.insertOne(shoppingCart);


        return "1";

    }


    @RequestMapping(value = "/postShoppingCart/{id}")
    public String addTOShoppingCart(@PathVariable(value = "id")int id,
                                    HttpSession session,
                                    @RequestParam(value = "quality",defaultValue = "1") int quality){
        if(session.getAttribute("userId") == null){
            return "redirect:/login";
        }
        int userId = (Integer)session.getAttribute("userId");

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProduct_id(id);
        shoppingCart.setQuality(quality);
        shoppingCart.setUser_id(userId);
        shoppingCartService.insertOne(shoppingCart);


        return "redirect:/good/shoppingCart";

    }
}
