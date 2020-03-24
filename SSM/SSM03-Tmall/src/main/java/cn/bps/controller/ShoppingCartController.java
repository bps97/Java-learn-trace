package cn.bps.controller;

import cn.bps.pojo.Product;
import cn.bps.pojo.ProductItem;
import cn.bps.service.ProductImageService;
import cn.bps.service.ProductService;
import cn.bps.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String showShoppingCartView(@ModelAttribute("userId")int userId, Model model){
        if(userId == 0) return "redirect:/login";

        List<ProductItem> productItems = shoppingCartService.getShoppingCartProductByUserId(userId);
        model.addAttribute("shoppingCarts", productItems);

        Map<Integer, Product> productMap = productService.getProductMapByShoppingCartList(productItems);
        model.addAttribute("productMap",productMap);

        Map<Integer, String> urls = productImageService.getImageUrls(productMap.values());
        model.addAttribute("images",urls);
        return "shoppingCart";
    }

	@RequestMapping(value = "/add.do/{id}")
    @ResponseBody
    public Integer ajaxAddShoppingCart(@ModelAttribute("userId")int userId,
                                       @PathVariable(value = "id")int productId,
                                       @RequestParam(value = "quality",defaultValue = "1") int quality){
        if(userId == 0) return 0;

        ProductItem productItem = shoppingCartService.findProductInShoppingCart(productId,userId);

        if(productItem == null){//购物车没有相似产品
            return shoppingCartService.insertOne(productId, userId, quality);
        }

        return shoppingCartService.ProductQualityAdd(productItem);

    }

	@RequestMapping(value = "/del.do")
    @ResponseBody
    public Integer ajaxDelShoppingCart(@ModelAttribute("userId")int userId,
                                       @RequestParam(value = "itemId",defaultValue = "0") int itemId){
        if(userId == 0) return 0;
        return shoppingCartService.removeOne(itemId);
    }

	@RequestMapping(value = "/update.do")
    @ResponseBody
    public Integer ajaxUpdateShoppingCart(@ModelAttribute("userId")int userId,
                                       @RequestParam(value = "itemId",defaultValue = "0") int itemId,
                                       @RequestParam(value = "quality",defaultValue = "1") int quality){
        if(userId == 0) return 0;
        return shoppingCartService.updateItemQualityByItemId(itemId,quality);
    }

	@RequestMapping(value = "/post/{id}")
    public String addTOShoppingCart(@ModelAttribute("userId")int userId,
                                    @PathVariable(value = "id")int productId,
                                    @RequestParam(value = "quality",defaultValue = "1") int quality){

        if(userId == 0) return "redirect:/login";

        ProductItem productItem = shoppingCartService.findProductInShoppingCart(productId,userId);
        if(productItem == null) {//购物车没有相似产品
            shoppingCartService.insertOne(productId, userId, quality);
        }else{
            shoppingCartService.ProductQualityAdd(productItem);

        }
        return "redirect:/shop";

    }

	@ModelAttribute("userId")
    public int updateShoppingCartSize(HttpSession session){
        if(session.getAttribute("userId")!=null){
            int userId = (Integer)(session.getAttribute("userId"));
            session.setAttribute("shoppingCartSize",shoppingCartService.countProductItem(userId));
            return userId;
        }
        return 0;
    }

}
