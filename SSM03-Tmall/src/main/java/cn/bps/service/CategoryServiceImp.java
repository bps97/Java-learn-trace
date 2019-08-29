package cn.bps.service;

import cn.bps.mapper.CategoryMapper;
import cn.bps.pojo.Category;
import cn.bps.pojo.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{


    @Autowired
    private CategoryMapper categoryMapper;

    public List<List<Category>> getCategories(int size){

        CategoryExample categoryExample = new CategoryExample();
        int gourpNumber = categoryMapper.getMaxGroupId();
        List<List<Category>> lists = new ArrayList<List<Category>>();
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        int start = 1;
        List<Category> list = new ArrayList<>();
        for(Category category:categories){
            if(start > size) return lists;
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
        return lists;
    }

    @Override
    public List<Category> getCategories() {

        CategoryExample categoryExample = new CategoryExample();
        return categoryMapper.selectByExample(categoryExample);
    }

}
