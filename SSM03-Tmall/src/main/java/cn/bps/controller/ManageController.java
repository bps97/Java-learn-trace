package cn.bps.controller;

import cn.bps.domain.Product;
import cn.bps.pojo.Category;
import cn.bps.pojo.ProductImage;
import cn.bps.service.CategoryService;
import cn.bps.service.ProductBindFilterService;
import cn.bps.service.ProductImageService;
import cn.bps.service.ProductService;
import cn.bps.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequestMapping(value = "/manage")
@Controller
public class ManageController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductBindFilterService productBindFilterService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductImageService productImageService;

    @RequestMapping(value = {"","/list"})
    public String showManage(Model model,
                             @RequestParam(value = "start",defaultValue = "0")int start)
    {


        Page page = new Page(start,8);
        Set<Integer> productIdSet = productBindFilterService.getProductIdSet();
        page.setTotal(productIdSet.size());

        List<cn.bps.pojo.Product> products = productService.rowBoundsProduct(productIdSet, page.getStart(), page.getStep());
        model.addAttribute("products",products);

        Map<Integer,String> categoryMap =categoryService.getCategoryMap();
        model.addAttribute("categoryMap",categoryMap);

        model.addAttribute("page",page);

        return "manage";
    }

//
//    @RequestMapping(value = "/add")
//    public String addProduct(Model model){
//        List<Category> categories = categoryService.getCategories();
//        model.addAttribute("categories",categories);
//
//        return "productEdit";
//    }

    @RequestMapping(value = "/edit/{id}")
    public String productInfoEdit(@PathVariable(value = "id")int id,
                                  Model model)
    {


        cn.bps.pojo.Product product = productService.getProductById(id);

        model.addAttribute("product", product);

        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);

        return "productEdit";
    }

    @RequestMapping(value = "/info/{id}")
    public String productInfo(@PathVariable(value = "id")int id,
                                  Model model)
    {


        cn.bps.pojo.Product product = productService.getProductById(id);

        model.addAttribute("product", product);

        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);

        return "productInfo";
    }

    @RequestMapping(value = "/del/{id}")
    public String productDel(@PathVariable(value = "id")int id)
    {



        cn.bps.pojo.Product product = productService.getProductById(id);
        if(productService.deleteOneById(id)==id){
            return "redirect:/manage";
        }

        //失败
        return "redirect:/manage";
    }

    @RequestMapping(value = "/postProduct/{id}", method = RequestMethod.POST)
    public String uploadImage(HttpServletRequest request,
                              @PathVariable(value = "id")int id,
                              @ModelAttribute Product product)
    {

        MultipartFile multipartFile = product.getMultipartFile();
        String fileName = multipartFile.getOriginalFilename();

        try{
            File file = new File(request.getServletContext().getRealPath("/WEB-INF/img/file"),fileName);

            System.out.println(file.getPath());
            multipartFile.transferTo(file);

            cn.bps.pojo.Product productPojo = product.toProduct(id);
            productService.updateOne(productPojo);
            productImageService.addProductImage(productPojo.getId(),fileName);



        }catch (IOException e){
            e.printStackTrace();
        }



        return "redirect:/list";
    }

}
