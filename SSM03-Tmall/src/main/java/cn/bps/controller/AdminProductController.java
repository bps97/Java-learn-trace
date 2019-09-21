package cn.bps.controller;


import cn.bps.domain.CompleteProduct;
import cn.bps.pojo.*;
import cn.bps.service.*;
import cn.bps.util.Util;
import cn.bps.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {


    @Autowired
    private ProductBindFilterService productBindFilterService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private ConcreteFilterService concreteFilterService;
    @Autowired
    private FilterCaseService filterCaseService;



    @RequestMapping("")
    public String showProductView(Model model,
                                  @RequestParam(value = "start", defaultValue = "0") int start,
                                  @RequestParam(value = "key", defaultValue = "") String key,
                                  @ModelAttribute("sessionUsername") String username) {

        if (username.equals("")) return "redirect:/admin/login";

        /*分页*/
        Page page = new Page(start, 8);
        Set<Integer> productIdSet = productBindFilterService.getAllProductIdSet();
        page.setTotal(productIdSet.size());

        Set<Integer> keyProductIdSet = productService.getProductIDSetByProductName(key);

        if (!key.equals("")) { //如果设置了关键字检索
            productIdSet.retainAll(keyProductIdSet);
        }

        /*开启下架产品*/
        List<Product> products = productService.rowBoundsProduct(productIdSet, page.getStart(), page.getStep(), true); //下架商品可见
        model.addAttribute("products", products);

        Map<Integer, String> categoryMap = categoryService.getCategoryMap();
        model.addAttribute("categoryMap", categoryMap);

        Map<Integer, String> images = productImageService.getImageUrls(products);
        model.addAttribute("images", images);


        model.addAttribute("page", page);

        return "admin/product/product";
    }

    @RequestMapping(value = "/add")
    public String showProductAddingView(Model model, @ModelAttribute("sessionUsername") String username) {

        if (username.equals("")) return "redirect:/admin/login";

        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);


        List<FilterCase> filterCases = filterCaseService.getFilterList();
        List<Integer> filterIdList = filterCaseService.getFilterIdList();
        Map<Integer, List<ConcreteFilter>> filterMap = concreteFilterService.getFilterMap(filterIdList);
        model.addAttribute("filterMap", filterMap);
        model.addAttribute("filterCases", filterCases);

        return "admin/product/productAdd";
    }

    //提交修改的产品
    @RequestMapping(value = "/edit/post/{id}", method = RequestMethod.POST)
    public String postProduct(HttpServletRequest request,
                              @PathVariable(value = "id") int id,
                              @ModelAttribute cn.bps.domain.Product product,
                              @ModelAttribute("sessionUsername") String username) {


        if (username.equals("")) return "redirect:/admin/login";

        //s商品信息上传
        MultipartFile multipartFile = product.getMultipartFile();
        String text = multipartFile.getOriginalFilename();
        String suffix = Util.matchSuffix(text);
        String fileName = Util.generatorRandomCode() + suffix;
        String filePath = null;

        if (text.equals("")) {
            filePath = "";
        } else {
            filePath = "/img/file/" + fileName;
            try {
                File file = new File(request.getServletContext().getRealPath("/WEB-INF/img/file/"), fileName);
                if (!file.exists()) {
                    file.mkdir();
                }
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //其他数据
        //原商品
        cn.bps.pojo.Product productPojo = product.toProduct(id);
        //编辑新商品的同时下架原商品
        Product newProduct = productService.editOne(productPojo);
        Integer newProductId = productService.getRecentProductId(newProduct);
        //拷贝筛选标签给新商品
        List<ProductBindFilter> productBindFilters = productBindFilterService.cloneByProductId(id, newProductId);
        productBindFilterService.insertProductBindFilter(productBindFilters);

        if(filePath.equals("")){
            String oldImg = productImageService.getImageUrl(productPojo.getId());
            productImageService.addProductImage(newProductId,oldImg);
        }
        //拷贝新商品的
        productImageService.addProductImage(newProductId, filePath);

        return "redirect:/admin/product?start="+id;
    }

    //提交添加的产品
    @RequestMapping(value = "/add/post", method = RequestMethod.POST)
    public String addProduct(HttpServletRequest request,
                             @ModelAttribute CompleteProduct completeProduct,
                             @ModelAttribute("sessionUsername") String username) {

        if (username.equals("")) return "redirect:/admin/login";

        cn.bps.pojo.Product product = completeProduct.generatorProduct();
        completeProduct.init();

        MultipartFile multipartFile = completeProduct.getImage();

        String text = multipartFile.getOriginalFilename();

        String suffix = Util.matchSuffix(text);

        String fileName = Util.generatorRandomCode() + suffix;

        String filePath = null;

        if (!text.equals("")) {
            try {
                filePath = "/img/file/" + fileName;
                File file = new File(request.getServletContext().getRealPath("/WEB-INF/img/file/"), fileName);
                if (!file.exists()) {
                    file.mkdir();
                }
                multipartFile.transferTo(file);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            filePath = "http://temp.im/200x200";
        }


        productService.insertOne(product);
        List<ProductBindFilter> productBindFilters = completeProduct.generatorProductBindFilter(product.getId());
        productBindFilterService.insertProductBindFilter(productBindFilters);

        productImageService.addProductImage(product.getId(), filePath);

        return "redirect: /admin/product";
    }

    //查看商品详细信息
    @RequestMapping(value = "/info/{id}")
    public String showProductInfoView(@PathVariable(value = "id") int id,
                                      Model model, @ModelAttribute("sessionUsername") String username) {

        if (username.equals("")) return "redirect:/admin/login";

        cn.bps.pojo.Product product = productService.getProductById(id);

        model.addAttribute("product", product);


        String imageUrl = productImageService.getImageUrl(product.getId());
        model.addAttribute("image", imageUrl);

        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);


        List<Integer> filterIdList = productBindFilterService.getConcreteFilterIdsByProduct(product);

        List<ConcreteFilter> concreteFilterList = concreteFilterService.getConcreteFilterByIds(filterIdList);

        model.addAttribute("filters",concreteFilterList);

        return "admin/product/productInfo";
    }


    @RequestMapping(value = "/edit/{id}")
    public String editProduct(@PathVariable(value = "id") int id,
                              Model model, @ModelAttribute("sessionUsername") String username) {

        if (username.equals("")) return "redirect:/admin/login";

        cn.bps.pojo.Product product = productService.getProductById(id);



        model.addAttribute("product", product);

        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);

        return "admin/product/productEdit";
    }

    @RequestMapping(value = "/del/{id}")
    public String delProduct(@PathVariable(value = "id") int id,
                             @ModelAttribute("sessionUsername") String username) {

        if (username.equals("")) return "redirect:/admin/login";

        //首先删除相关筛选
        cn.bps.pojo.Product product = productService.getProductById(id);
        productBindFilterService.deleteDemos(id);

        if (productImageService.deleteOneByProductId(id) > 0){
            int productId = productService.deleteOneById(id);
            if (productId == id) {
                return "redirect:/admin/manage";
            }
        }
        //失败
        return "redirect:/admin/product";
    }


    @ModelAttribute("sessionUsername")
    public String BeforeAdminController(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username != null) {
            return username;
        }
        return "";
    }


}
