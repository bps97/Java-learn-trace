package cn.bps.mms.service.impl;

import cn.bps.mms.entity.Category;
import cn.bps.mms.mapper.CategoryMapper;
import cn.bps.mms.service.CategoryService;
import cn.bps.mms.domian.vo.CategoryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public IPage<CategoryVo> pageCategories(Page page) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available",true)
                .eq("level",0);
        Page pageCategories = (Page) this.page(page,wrapper);
        List vos = model2Vo(pageCategories.getRecords());
        IPage<CategoryVo> iPage = pageCategories.setRecords(vos);
        return iPage;
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
    public String getIdByCategoryName(String categoryName) {
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
        CategoryVo vo = model2Vo(getById(id));
        vo.setSpecialLine(getRootCategoryName(id));
        return vo;

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

    @Override
    public String getRootCategoryName(String categoryId) {
        Category category = this.getById(categoryId);
        if(Objects.nonNull(category.getParentId())){
            return getRootCategoryName(category.getParentId());
        }
        return category.getName();
    }

    @Override
    public void updateById(String id, Category category) {
        category.setId(id);
        this.updateById(category);
    }

    @Override
    public void addCategory(Category category) {
        int parentLevel = getLevel(category.getParentId());
        category.setLevel(parentLevel+1);
        this.save(category);
    }

    private int getLevel(String categoryId){
        Category category = this.getById(categoryId);
        int level = 0;
        String parentId = category.getParentId();
        while (Objects.nonNull(category.getParentId())){
            level++;
            category = this.getById(parentId);
        }
        return level;
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
