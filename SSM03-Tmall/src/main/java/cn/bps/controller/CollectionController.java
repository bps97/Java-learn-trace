package cn.bps.controller;

import cn.bps.pojo.CollectionItem;
import cn.bps.pojo.Product;
import cn.bps.service.CollectionItemService;
import cn.bps.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    CollectionItemService collectionItemService;
    @Autowired
    ProductService productService;


    @RequestMapping(value = "")
    public String showCollectionView(Model model){

        List<CollectionItem> collectionItems = collectionItemService.getAllCollection();
        model.addAttribute("collection",collectionItems);

        Set<Integer> productIdSet = collectionItemService.getAllProductIDSet();

        List<Product> products = productService.getProductListByProductIdSet(productIdSet);
        model.addAttribute("products",products);


        return "collection";
    }

}
