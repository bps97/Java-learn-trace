package cn.bps.mms.service.impl;

import cn.bps.common.lang.api.Page;
import cn.bps.mms.domain.PageRequest;
import cn.bps.mms.entity.Authentication;
import cn.bps.mms.entity.Category;
import cn.bps.mms.mapper.CategoryMapper;
import cn.bps.mms.service.CategoryService;
import cn.bps.mms.vo.AuthenticationVo;
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
        Page<CategoryVo> page = new Page(categories);
        pageRequest.initPage(page);
        page.setTotal(this.count());
        return page;

    }

    @Override
    public Page<CategoryVo> pageCategories(PageRequest pageRequest, Integer level) {
        List<CategoryVo> categories = listCategories(level);
        Page<CategoryVo> page = new Page(categories);
        pageRequest.initPage(page);
        page.setTotal(this.count());
        return page;
    }

    @Override
    public List<CategoryVo> listCategories() {
        List<Category> rootCategories = rootCategories();
        List<CategoryVo> categories = model2Vo(rootCategories);
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
                .eq("level",1);
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

    @Override
    public List<Category> getChildren(String parentId) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper
        //      .eq("available", true)
                .eq("parent_id", parentId);
        List<Category> authentications = this.list(wrapper);
        return authentications;
    }

    private List<CategoryVo> model2Vo(List<Category> categories) {
        return model2Vo(categories, Integer.MAX_VALUE);
    }

    private List<CategoryVo> model2Vo(List<Category> categories, Integer level) {

        List<CategoryVo> lists = Lists.newArrayList();

        for(Category parent: categories){
            List<Category> children = getChildren(parent.getId());
            CategoryVo vo = new CategoryVo();
            vo.setName(parent.getName());
            vo.setId(parent.getId());
            vo.setAvailable(parent.getAvailable());
            vo.setCreateTime(parent.getCreateTime());
            vo.setUpdateTime(parent.getUpdateTime());
            vo.setLevel(parent.getLevel());
            //    vo.setSpecialLine()
            if(Objects.equals(0, level) == false) {
                vo.setChildren(model2Vo(children,level-1));
            }
            lists.add(vo);
        }
        return lists.isEmpty() ? null: lists;

    }
}
