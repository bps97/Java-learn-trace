package cn.bps.controller;

import cn.bps.domain.CompleteProduct;
import cn.bps.domain.Product;
import cn.bps.pojo.Category;
import cn.bps.pojo.ConcreteFilter;
import cn.bps.pojo.FilterCase;
import cn.bps.pojo.ProductBindFilter;
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

@RequestMapping(value = "/manage")
@Controller
public class ManageController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductBindFilterService productBindFilterService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private FilterCaseService filterCaseService;

    @Autowired
    private ConcreteFilterService concreteFilterService;

    @RequestMapping(value = {"","/list","s"})
    public String showManage(Model model,
                             @RequestParam(value = "start",defaultValue = "0")int start)
    {


        Page page = new Page(start,8);
        Set<Integer> productIdSet = productBindFilterService.getAllProductIdSet();
        page.setTotal(productIdSet.size());

        List<cn.bps.pojo.Product> products = productService.rowBoundsProduct(productIdSet, page.getStart(), page.getStep());
        model.addAttribute("products",products);

        Map<Integer,String> categoryMap =categoryService.getCategoryMap();
        model.addAttribute("categoryMap",categoryMap);





        model.addAttribute("page",page);

        return "manage";
    }


    @RequestMapping(value = "/add")
    public String addProduct(Model model){
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);


        List<FilterCase> filterCases = filterCaseService.getFilterList();
        List<Integer> filterIdList = filterCaseService.getFilterIdList();
        Map<Integer, List<ConcreteFilter>> filterMap = concreteFilterService.getFilterMap(filterIdList);
        model.addAttribute("filterMap",filterMap);
        model.addAttribute("filterCases",filterCases);

        return "AddProduct";
    }

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


        String imageUrl = productImageService.getImageUrl(product.getId());
        model.addAttribute("image",imageUrl);

        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);

        return "productInfo";
    }

    @RequestMapping(value = "/del/{id}")
    public String productDel(@PathVariable(value = "id")int id)
    {



        cn.bps.pojo.Product product = productService.getProductById(id);
        productBindFilterService.deleteDemos(id);

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



        return "redirect:/manage/list";
    }


    @RequestMapping(value = "/postProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute CompleteProduct completeProduct)
    {

        cn.bps.pojo.Product product = completeProduct.generatorProduct();
        completeProduct.init();

        productService.getProductById(0);
        productService.insertOne(product);
        List<ProductBindFilter> productBindFilters = completeProduct.generatorProductBindFilter(product.getId());
        productBindFilterService.insertProductBindFilter(productBindFilters);

        return "redirect:/manage/list";
    }
}
