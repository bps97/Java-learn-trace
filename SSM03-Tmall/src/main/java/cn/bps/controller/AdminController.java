package cn.bps.controller;


import cn.bps.domain.CompleteProduct;
import cn.bps.pojo.*;
import cn.bps.service.*;
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

@Controller
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private ProductBindFilterService productBindFilterService;
    @Autowired
    private ProductService  productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private ConcreteFilterService concreteFilterService;
    @Autowired
    private FilterCaseService filterCaseService;


    @RequestMapping("/base")
    public String showBase(){
        return "/admin2/base";
    }


    @RequestMapping("/index")
    public String showIndex(){
        return "/admin2/index";
    }

    @RequestMapping("/demo")
    public String showDemo(){
        return "/admin2/demo";
    }

    @RequestMapping("/product")
    public String showProduct(Model model,
                              @RequestParam(value = "start",defaultValue = "0")int start){


        Page page = new Page(start,8);
        Set<Integer> productIdSet = productBindFilterService.getAllProductIdSet();
        page.setTotal(productIdSet.size());

        List<Product> products = productService.rowBoundsProduct(productIdSet, page.getStart(), page.getStep());
        model.addAttribute("products",products);

        Map<Integer,String> categoryMap =categoryService.getCategoryMap();
        model.addAttribute("categoryMap",categoryMap);

        Map<Integer, String> images = productImageService.getImageUrls(products);
        model.addAttribute("images",images);



        model.addAttribute("page",page);

        return "/admin2/product";
    }

    @RequestMapping(value = "/product/add")
    public String showProductAdding(Model model){
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);


        List<FilterCase> filterCases = filterCaseService.getFilterList();
        List<Integer> filterIdList = filterCaseService.getFilterIdList();
        Map<Integer, List<ConcreteFilter>> filterMap = concreteFilterService.getFilterMap(filterIdList);
        model.addAttribute("filterMap",filterMap);
        model.addAttribute("filterCases",filterCases);

        return "/admin2/productAdd";
    }

    @RequestMapping(value = "/product/post/{id}", method = RequestMethod.POST)
    public String postProduct(HttpServletRequest request,
                              @PathVariable(value = "id")int id,
                              @ModelAttribute cn.bps.domain.Product product)
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



        return "redirect:/admin/product";
    }

    //提交添加的产品
    @RequestMapping(value = "/product/add/post", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute CompleteProduct completeProduct)
    {

        cn.bps.pojo.Product product = completeProduct.generatorProduct();
        completeProduct.init();

        productService.getProductById(0);
        productService.insertOne(product);
        List<ProductBindFilter> productBindFilters = completeProduct.generatorProductBindFilter(product.getId());
        productBindFilterService.insertProductBindFilter(productBindFilters);

        return "redirect: /admin/product";
    }

    //查看商品详细信息
    @RequestMapping(value = "/product/info/{id}")
    public String showProductInfo(@PathVariable(value = "id")int id,
                              Model model)
    {


        cn.bps.pojo.Product product = productService.getProductById(id);

        model.addAttribute("product", product);


        String imageUrl = productImageService.getImageUrl(product.getId());
        model.addAttribute("image",imageUrl);

        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);

        return "admin2/productInfo";
    }

    //修改商品信息
    @RequestMapping(value = "/product/edit/{id}")
    public String editProduct(@PathVariable(value = "id")int id,
                                  Model model)
    {
        //建议是新建一个，下架原来的

        cn.bps.pojo.Product product = productService.getProductById(id);

        model.addAttribute("product", product);

        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);

        return "/admin2/productEdit";
    }
    
    @RequestMapping(value = "/product/del/{id}")
    public String delProduct(@PathVariable(value = "id")int id)
    {



        cn.bps.pojo.Product product = productService.getProductById(id);
        productBindFilterService.deleteDemos(id);

        if(productService.deleteOneById(id)==id){
            return "redirect:/admin/manage";
        }

        //失败
        return "redirect:/admin/product";
    }

}
