package cn.bps.heam.mapper;

import cn.bps.heam.SsmApplication;
import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.heam.domain.model.ProductCategoryExample;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SsmApplication.class)
@EnableAutoConfiguration
public class TMapperTest {

    @Resource
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
