package cn.bps.service;

import cn.bps.mapper.SubCategoryMapper;
import cn.bps.pojo.Category;
import cn.bps.pojo.SubCategory;
import cn.bps.pojo.SubCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubCategoryServiceImp implements SubCategorySerivce {

    @Autowired
    SubCategoryMapper subcategoryMapper;

    @Autowired
    CategoryService categoryService;

    public List<SubCategory> getCategoryDemos(int id){

        SubCategoryExample subCategoryExample = new SubCategoryExample();
        subCategoryExample.createCriteria().andCategoryIdEqualTo(id);
        List<SubCategory> list = subcategoryMapper.selectByExample(subCategoryExample);

        return list;
    }

    public Map<Integer,List<SubCategory>> getCategoryProduct(){
        List<Category> categories = categoryService.getCategories();
        Map<Integer,List<SubCategory>> container = new HashMap<>();
        for(Category category: categories){
            container.put(category.getId(),getCategoryDemos(category.getId()));
        }
        return container;

    }



}
