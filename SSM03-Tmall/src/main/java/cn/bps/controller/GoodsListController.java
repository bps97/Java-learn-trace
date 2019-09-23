package cn.bps.controller;

import cn.bps.pojo.*;
import cn.bps.service.*;
import cn.bps.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RequestMapping(value = "/good")
@Controller
public class GoodsListController {

    @Autowired
    private LabelCategoryService labelCategoryService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductBindLabelService productBindLabelService;

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private PropertyService propertyService;


    @RequestMapping(value = "{id}")
    public String showGood(@PathVariable(value = "id") int id,
                           Model model) {

        Product product = productService.getProductById(id);

        model.addAttribute("product", product);

        String imgUrl = productImageService.getImageUrl(product.getId());
        model.addAttribute("imgUrl", imgUrl);

        List<Property> properties = propertyService.getPropertyListByCategoryId(product.getCategory_id());
        model.addAttribute("properties", properties);

        return "goodInfo";
    }

	@RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public String listGoods(@RequestParam(value = "caseList", defaultValue = "") String caseList,
                            @RequestParam(value = "start", defaultValue = "0") int start,

                            @RequestParam(value = "key", defaultValue = "") String key,
                            Model model) {


        /* 筛选条件 */
        List<LabelCategory> labelCategory = labelCategoryService.getAllLabelCategory();//获取所有的标签分类
        Map<LabelCategory, List<Label>> map = labelService.getLabelMap(labelCategory);//获取标签分类和标签的字典表
        model.addAttribute("labelMap", map);
        model.addAttribute("labelCategory",labelCategory);  //考虑到map的keyset方法无序。。


        /*分页*/

        Page page = new Page(start, 20);
        model.addAttribute("page", page);

        /*检索词*/
        model.addAttribute("key", key);


        /* 产品 */
        Set<Integer> keyProductIdSet = productService.getProductIDSetByProductName(key);//由关键字筛选之后的产品id集合
        Set<Integer> labelProductIdSet = null;//由标签筛选之后的产品id集合

        if (caseList.equals("") || caseList.equals("全部,全部,全部,全部,全部,全部")) {//未选择其他标签时
            labelProductIdSet = productBindLabelService.getAllProductIdSet();

            if (!key.equals("")) {
                labelProductIdSet.retainAll(keyProductIdSet);
            }

        } else {
            String[] temp = caseList.split(",");
            Set<Integer> labelIdSet = labelService.getLabelIds(temp);//获取筛选条件
            labelProductIdSet = productBindLabelService.getProductIdSet(labelIdSet);//根据筛选条件获取产品id
            if (!key.equals("")) {
                labelProductIdSet.retainAll(keyProductIdSet);
            }

            model.addAttribute("labelInfo",labelService.labelIdSetToString(labelIdSet));
        }
        List<Product> products = productService.rowBoundsProduct(labelProductIdSet, page.getStart(), page.getStep());

        model.addAttribute("products", products);
        Map<Integer, String> urlMap = productImageService.getImageUrls(products);//获取产品图片链接
        model.addAttribute("urlMap", urlMap);


        return "/goods";

    }

}
