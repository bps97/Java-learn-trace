package cn.bps.heam.service;

import cn.bps.heam.domain.model.Product;
import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.common.lang.util.Generator;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

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


    @Test

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
