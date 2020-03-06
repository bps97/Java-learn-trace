package service;

import cn.bps.hea.domain.model.ProductCategory;
import cn.bps.hea.service.ProductCategoryService;
import cn.bps.hea.service.ProductAttributeDictService;
import cn.bps.hea.service.ProductAttributeService;
import cn.bps.util.Generator;
import cn.bps.hea.domain.model.ProductAttribute;
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

    @Test
    public void productAttributeDictTest(){

        Map<String, String> map = productAttributeDictService.getAttributeDict("243be4c2585b11ea9ebc00ff");
        System.out.println(map);


    }


    @Test
    public void  productAttributeTest(){

        List<ProductAttribute> productAttributes = productAttributeService.listProductAttributes();
        System.out.println(productAttributes);

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
