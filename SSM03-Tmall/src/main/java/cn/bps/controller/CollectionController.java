package cn.bps.controller;

import cn.bps.pojo.CollectionItem;
import cn.bps.pojo.Product;
import cn.bps.service.CollectionItemService;
import cn.bps.service.ProductImageService;
import cn.bps.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionItemService collectionItemService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductImageService productImageService;


    @RequestMapping(value = "")
    public String showCollectionView(Model model,@ModelAttribute("userId")int userId){

        if(userId == 0) return "redirect:/login";

        Map<CollectionItem, Product> productMap = collectionItemService.getProductMap();
        if(productMap.size()>0)
            model.addAttribute("productMap",productMap);

        Set<Integer> productIdSet = collectionItemService.getAllProductIDSet();
        if(productIdSet != null) {
            List<Product> products = productService.getProductListByProductIdSet(productIdSet);
            if (products.size() > 0) {
                Map<Integer, String> images = productImageService.getImageUrls(products);
                model.addAttribute("images", images);
            }
        }
        return "collection";
    }

    @RequestMapping(value = "/del.do")
    @ResponseBody
    public Integer ajaxDelCollection(@ModelAttribute("userId")int userId,
                                       @RequestParam(value = "itemId",defaultValue = "0") int itemId){
        if(userId == 0) return 0;
        return collectionItemService.removeCollectionItem(itemId);
    }


    @RequestMapping(value = "/add.do")
    @ResponseBody
    public Integer ajaxAddCollection(@ModelAttribute("userId")int userId,
                                     @RequestParam(value = "productId", defaultValue = "0")int productId){
        if(productId == 0) return 0;
        if(userId == 0) return 0;


        CollectionItem collectionItem = new CollectionItem();
        collectionItem.setProduct_id(productId);
        collectionItem.setUser_id(1);
        return collectionItemService.addCollectionItem(collectionItem);
    }


    @ModelAttribute("userId")
    public int updateShoppingCartSize(HttpSession session){
        if(session.getAttribute("userId")!=null){
            int userId = (Integer)(session.getAttribute("userId"));
            return userId;
        }
        return 0;
    }

}
