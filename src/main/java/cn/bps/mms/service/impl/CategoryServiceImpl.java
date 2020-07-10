package cn.bps.mms.service.impl;

import cn.bps.mms.domain.vo.KeyValue;
import cn.bps.mms.entity.Category;
import cn.bps.mms.mapper.CategoryMapper;
import cn.bps.mms.service.CategoryService;
import cn.bps.mms.domain.vo.CategoryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 分类 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public IPage<CategoryVo> pageCategories(Page<Category> page, String specialLineId) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper
                .eq("parent_id", specialLineId);
        IPage pageCategories = (IPage) this.page(page,wrapper);
        List vos = model2Vo(pageCategories.getRecords(),false);
        IPage<CategoryVo> iPage = pageCategories.setRecords(vos);
        return iPage;
    }

    @Override
    public List<CategoryVo> menuCategories() {
        List<Category> rootCategories = rootCategories();   /*获取根分类*/
        List<CategoryVo> categories = model2Vo(rootCategories,true);
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
//                .eq("available",true)
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

    /*默认是全部*/
    @Override
    public List<Category> getChildren(String parentId) {
        return getChildren(parentId, false);
    }

    @Override
    public CategoryVo getVoById(String id) {
        CategoryVo vo = model2VoInit(getById(id));
        vo.setSpecialLine(getRootCategoryName(id));
        return vo;

    }

    @Override
    public void changeAvailable(String id, Boolean available) {
        Category category = new Category();
        category.setId(id);
        if(available == Boolean.FALSE){
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

    @Override
    public List<KeyValue> listSpecialLines() {
        return this.rootCategories().stream().map(e->{
            KeyValue keyValue = new KeyValue();
            keyValue.setKey(e.getId());
            keyValue.setValue(e.getName());
            return keyValue;
        }).collect(Collectors.toList());
    }

    @Override
    public Map<String, String>  getNameIdDict(Set<String> categoryNames) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.in("name",categoryNames);
        return this.list(wrapper).stream()
                .collect(Collectors.toMap(Category::getName, Category::getId));
    }


    private int getLevel(String categoryId){
        Category category = this.getById(categoryId);
        int level = 0;
        String parentId = category.getParentId();
        while (Objects.nonNull(parentId)){
            level++;
            category = this.getById(parentId);
            parentId = category.getParentId();
        }
        return level;
    }

    private void closeCategory(Category category){
        category.setAvailable(false);
        this.updateById(category);
    }


    private List<CategoryVo> model2Vo(List<Category> categories, boolean available){
        List<CategoryVo> lists = Lists.newArrayList();
        for(Category parent: categories){
            CategoryVo vo = model2VoInit(parent);
            List<Category> children = this.getChildren(parent.getId(), available); /*获取有效的子分类*/
            vo.setChildren(model2Vo(children, available));
            lists.add(vo);
        }
        return lists.isEmpty() ? null: lists;
    }


    private CategoryVo model2VoInit(Category category){
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
