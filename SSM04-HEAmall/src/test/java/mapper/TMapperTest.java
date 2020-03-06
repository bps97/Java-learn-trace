package mapper;


import cn.bps.hea.mapper.ProductCategoryMapper;
import cn.bps.hea.domain.model.*;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TMapperTest {

    @Autowired
    private ProductCategoryMapper categoryMapper;

    @Test
    public void categoryTest(){

        ProductCategoryExample categoryExample = new ProductCategoryExample();
        List<ProductCategory> categories = categoryMapper.selectByExample(categoryExample);
        for(ProductCategory category : categories){
            System.out.println(category.getCategoryName());
        }

        System.out.println(categories.size());
        System.out.println(JSON.toJSONString(categories));

    }

}
