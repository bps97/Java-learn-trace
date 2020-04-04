package service;

import cn.bps.hea.domain.model.Product;
import cn.bps.hea.domain.model.ProductCategory;
import cn.bps.hea.service.ProductCategoryService;
import cn.bps.hea.service.ProductAttributeDictService;
import cn.bps.hea.service.ProductAttributeService;
import cn.bps.hea.service.ProductService;
import cn.bps.util.Generator;
import cn.bps.hea.domain.model.ProductAttribute;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TServiceTest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductAttributeService productAttributeService;

    @Autowired
    private ProductAttributeDictService productAttributeDictService;

    @Autowired
    private ProductService productService;


    @Test
    public void getProductAttributes(){
        Product product = productService.listProducts().get(0);
        List<String> attributes = productService.listAttributes(product);
        System.out.println(attributes);
    }

    @Test
    public void getProductAttributeDict(){

        Product product = productService.listProducts().get(0);

        Map<String, String> result = productService.getAttributeDict(product);

        System.out.println(result.size());

        for(Map.Entry<String,String> entity:result.entrySet()){
            System.out.println(JSON.toJSONString(entity));
        }

    }


    @Test /*获取产品属性列表*/
    public void  listProductAttributes(){

        List<ProductAttribute> productAttributes = productAttributeService.listProductAttributes();
        productAttributes.stream().map(JSON::toJSONString).forEach(System.out::println);

    }

    @Test
    public void categoryTest(){

        List<ProductCategory> categories = productCategoryService.listProductCategories();
        for(ProductCategory category : categories){
            System.out.println(category.getCategoryName()+","+category.getCreateTime()+","+category.getId());
        }

        String uuid = Generator.getUUID();

//        System.out.println(Generator.now());

        ProductCategory category = new ProductCategory();
        category.setId("2b0e6a5c54b848d6a315d3ab");
        category.setCategoryName("吹风机");
        category.setAvailable(true);
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());

        System.out.println(category.getCategoryName()+","+category.getCreateTime()+","+category.getId());
        int result = productCategoryService.saveProductCategory(category);
        System.out.println(result);
    }

}
