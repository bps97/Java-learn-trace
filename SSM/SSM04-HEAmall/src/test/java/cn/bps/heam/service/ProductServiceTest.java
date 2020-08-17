package cn.bps.heam.service;

import cn.bps.common.lang.api.Filter;
import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.domain.Ret;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.Product;
import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.common.lang.util.Generator;
import cn.bps.heam.domain.result.ProductResult;
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
    private CategoryService categoryService;

    @Autowired
    private AttributeService attributeService;

    @Autowired
    private ProductService productService;

    @Test
    public void getProductCategoryName(){
        ProductCategory result = categoryService.getCategoryByName("电视");
        System.out.println(result.getCategoryName());
    }


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

        List<ProductAttribute> productAttributes = attributeService.listProductAttributes();
        Ret<List<ProductAttribute>> ret = Ret.ok(productAttributes);
        System.out.println(JSON.toJSONString(ret));
        System.out.println(JSON.toJSONString(Ret.error()));

    }

    @Test
    public void categoryTest(){

        List<ProductCategory> categories = categoryService.listProductCategories();
        for(ProductCategory category : categories){
            System.out.println(category.getCategoryName()+","+category.getCreateTime()+","+category.getId());
        }

        String uuid = Generator.getUUID();

//        System.out.println(TimeUtils.now());

        ProductCategory category = new ProductCategory();
        category.setId(uuid);
        category.setCategoryName("吹风机");
        category.setAvailable(true);
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());

        System.out.println(category.getCategoryName()+","+category.getCreateTime()+","+category.getId());
//        int result = categoryService.saveProductCategory(category);
//        System.out.println(result);
    }


    @Test
    public void productFilter(){
        Filter filter = Filter.condition();
        filter.add(new Filter.Property("category","冰箱"));
        filter.add(new Filter.Property("制冷方式", "风冷"));
        filter.addEndWith("压缩机", "变频");
        filter.addEndWith("箱门结构","对开门");
        Page<ProductResult> productPage = productService.pageProducts(new PageRequest(1, 100), filter);
        System.out.println(JSON.toJSONString(productPage));
    }

}
