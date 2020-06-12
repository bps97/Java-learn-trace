package cn.bps.mms.service.impl;

import cn.bps.common.lang.api.Page;
import cn.bps.mms.domain.PageRequest;
import cn.bps.mms.entity.Category;
import cn.bps.mms.mapper.CategoryMapper;
import cn.bps.mms.service.CategoryService;
import cn.bps.mms.vo.CategoryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 分类项 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    @Override
    public Page<CategoryVo> pageCategories(PageRequest pageRequest) {
        List<CategoryVo> categories = listCategories();
        Page<CategoryVo> Page = new Page(categories);
        pageRequest.initPage(Page);
        Page.setTotal(this.count());
        return Page;

    }

    @Override
    public Page<CategoryVo> pageCategories(PageRequest pageRequest, Integer level) {
        if(Objects.isNull(level)){
            level = Integer.MAX_VALUE;
        }
        List<CategoryVo> categories = listCategories(level);
        Page<CategoryVo> Page = new Page(categories);
        pageRequest.initPage(Page);
        Page.setTotal(this.count());
        return Page;
    }

    @Override
    public List<CategoryVo> listCategories() {
        List<Category> rootCategories = rootCategories();
        List<CategoryVo> categories = model2Vo(rootCategories);
        return categories;
    }

    @Override
    public List<CategoryVo> listCategories(boolean available) {
        List<Category> rootCategories = rootCategories();
        List<CategoryVo> categories = model2Vo(rootCategories ,available);
        return categories;
    }

    @Override
    public List<CategoryVo> listCategories(Integer level) {
        List<Category> rootCategories = rootCategories();
        List<CategoryVo> categories = model2Vo(rootCategories, level);
        return categories;
    }

    @Override
    public List<Category> rootCategories() {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available",true)
                .eq("level",0);
        return this.list(wrapper);
    }

    @Override
    public String getId(String categoryName) {
        Category category  = getByName(categoryName);
        return Objects.isNull(category) ? null : category.getId();
    }

    @Override
    public Category getByName(String categoryName) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available",true)
                .eq("name",categoryName);
        return this.getOne(wrapper);
    }

    @Override
    public void save(String categoryName) {
        Category category = new Category();
        category.setName(categoryName);
        this.save(category);
        // 得修改
    }

    public List<Category> getChildren(String parentId, boolean available) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper
                .eq("parent_id", parentId);
        if(available == true){ // 要求有效的
            wrapper.
                    eq("available", true);
        }
        List<Category> authentications = this.list(wrapper);
        return authentications;
    }

    @Override
    public List<Category> getChildren(String parentId) {
        return getChildren(parentId, false);
    }

    @Override
    public CategoryVo getVoById(String id) {
        return model2Vo(getById(id));

    }

    @Override
    public void changeAvailable(String id, Boolean available) {
        Category category = new Category();
        category.setId(id);
        if(available == false){
            List<Category> children = getChildren(id);
            children.stream().forEach(this::closeCategory);
        }
        category.setAvailable(available);
        this.updateById(category);
    }

    private void closeCategory(Category category){
        category.setAvailable(false);
        this.updateById(category);
    }

    private List<CategoryVo> model2Vo(List<Category> categories) {
        return model2Vo(categories, Integer.MAX_VALUE, false);
    }

    private List<CategoryVo> model2Vo(List<Category> categories, boolean available) {
        return model2Vo(categories, Integer.MAX_VALUE, available);
    }

    private List<CategoryVo> model2Vo(List<Category> categories, Integer level) {
        return model2Vo(categories, Integer.MAX_VALUE, false);
    }

    private List<CategoryVo> model2Vo(List<Category> categories, Integer level, boolean available) {

        List<CategoryVo> lists = Lists.newArrayList();

        for(Category parent: categories){
            CategoryVo vo = model2Vo(parent);
            List<Category> children = getChildren(parent.getId(), available);

            if(Objects.equals(0, level) == false) {
                vo.setChildren(model2Vo(children,level-1, available));
            }
            lists.add(vo);
        }
        return lists.isEmpty() ? null: lists;

    }

    private CategoryVo model2Vo(Category category){
        CategoryVo vo = new CategoryVo();
        vo.setName(category.getName());
        vo.setId(category.getId());
        vo.setAvailable(category.getAvailable());
        vo.setCreateTime(category.getCreateTime());
        vo.setUpdateTime(category.getUpdateTime());
        vo.setLevel(category.getLevel());
        vo.setChildren(null);
        //    这个后期可以考虑改成Redis

        return vo;
    }
}
