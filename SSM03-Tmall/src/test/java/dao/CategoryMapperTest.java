package dao;

import cn.bps.mapper.CategoryMapper;
import cn.bps.pojo.Category;
import cn.bps.pojo.CategoryExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void test(){
        CategoryExample categoryExample = new CategoryExample();
        int gourpNumber = categoryMapper.getMaxGroupId();
        List<List<Category>> lists = new ArrayList<List<Category>>();
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        int start = 1;
        List<Category> list = new ArrayList<>();




        for(Category category:categories){

            if(category.getGroup_id() == start && start <= gourpNumber){
                list.add(category);
            }else {

                List<Category> temp = new ArrayList<>(list);
                lists.add(temp);
                list.clear();
                list.add(category);
                ++start;
            }

        }

    }
}
