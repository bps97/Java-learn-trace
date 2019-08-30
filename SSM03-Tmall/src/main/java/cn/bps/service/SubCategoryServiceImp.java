package cn.bps.service;

        import cn.bps.mapper.CategoryDemoMapper;
        import cn.bps.pojo.Category;
        import cn.bps.pojo.CategoryDemo;
        import cn.bps.pojo.CategoryDemoExample;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

@Service
public class CategoryDemoServiceImp implements CategoryDemoSerivce {

    @Autowired
    CategoryDemoMapper categoryDemoMapper;

    @Autowired
    CategoryService categoryService;

    public List<CategoryDemo> getCategoryDemos(int id){

        CategoryDemoExample categoryDemoExample = new CategoryDemoExample();
        categoryDemoExample.createCriteria().andCategoryIdEqualTo(id);
        List<CategoryDemo> list = categoryDemoMapper.selectByExample(categoryDemoExample);

        return list;
    }

    public Map<Integer,List<CategoryDemo>> getCategoryProduct(){
        List<Category> categories = categoryService.getCategories();
        Map<Integer,List<CategoryDemo>> container = new HashMap<>();
        for(Category category: categories){
            container.put(category.getId(),getCategoryDemos(category.getId()));
        }
        return container;

    }



}
