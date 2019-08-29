package dao;

import cn.bps.mapper.CategoryDemoMapper;
import cn.bps.pojo.Category;
import cn.bps.pojo.CategoryDemo;
import cn.bps.pojo.CategoryDemoExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class CategoryDemoMapperTest {

    @Autowired
    private CategoryDemoMapper categoryDemoMapper;

    @Test
    public void test(){

        Category category = new Category();
        category.setId(15);
        CategoryDemoExample categoryDemoExample = new CategoryDemoExample();
        categoryDemoExample.createCriteria().andCategoryIdEqualTo(category.getId());
        List<CategoryDemo> list = categoryDemoMapper.selectByExample(categoryDemoExample);
        System.out.println(list.toArray().toString());
    }
}
