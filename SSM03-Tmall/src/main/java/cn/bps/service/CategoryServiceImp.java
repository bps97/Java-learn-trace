package cn.bps.service;

import cn.bps.mapper.CategoryMapper;
import cn.bps.pojo.Category;
import cn.bps.pojo.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImp implements CategoryService{


    @Autowired
    private CategoryMapper categoryMapper;

    public List<List<Category>> getAllCategory(int size){

        CategoryExample categoryExample = new CategoryExample();
        long groupNumber = categoryMapper.countByExample(categoryExample);
        List<List<Category>> lists = new ArrayList<>();
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        int start = 1;
        List<Category> list = new ArrayList<>();
        for(Category category:categories){
            if(start > size) return lists;
            if(category.getGroup_id() == start && start <= groupNumber){
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

	@Override
    public Map<Integer, String> getCategoryMap() {
        List<Category> categories = getCategories();
        Map<Integer,String> categoryMap = new HashMap<>();
        for(Category category : categories){
            categoryMap.put(category.getId(),category.getName());
        }
        return categoryMap;
    }

}
