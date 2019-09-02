package dao;


import cn.bps.mapper.CategoryMapper;
import cn.bps.mapper.FilterCaseMapper;
import cn.bps.mapper.SubCategoryMapper;
import cn.bps.mapper.UserMapper;
import cn.bps.pojo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestDao {

    @Autowired
    private SubCategoryMapper subCategoryMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FilterCaseMapper filterCaseMapper;



    @Test
    public void filterCaseTest(){
        FilterCaseExample filterExample = new FilterCaseExample();
        List<FilterCase> list = filterCaseMapper.selectByExample(filterExample);

        for(FilterCase ca:list){
            System.out.println(ca.getName());
        }
    }







    @Test
    public void subCategoryTest(){

        Category category = new Category();
        category.setId(15);
        SubCategoryExample subCategoryExample = new SubCategoryExample();
        subCategoryExample.createCriteria().andCategoryIdEqualTo(category.getId());
        List<SubCategory> list = subCategoryMapper.selectByExample(subCategoryExample);
        System.out.println(list.toArray().toString());
    }


    @Test
    public void categoryTest(){
        CategoryExample categoryExample = new CategoryExample();
        long gourpNumber = categoryMapper.countByExample(categoryExample);
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


    @Test
    public void userTest(){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo("admin");
        User user = (userMapper.selectByExample(userExample).isEmpty())?null:userMapper.selectByExample(userExample).get(0);
        if(user == null){
            System.out.println("??");
        }else{
            System.out.println(user.getName());
        }
        System.out.println(userMapper.selectByPrimaryKey(1).getName());
    }

}
