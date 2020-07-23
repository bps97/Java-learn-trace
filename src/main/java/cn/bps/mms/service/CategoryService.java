package cn.bps.mms.service;

import cn.bps.mms.domain.vo.KeyValue;
import cn.bps.mms.entity.Category;
import cn.bps.mms.domain.vo.CategoryTreeVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 分类 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
public interface CategoryService extends IService<Category> {

    IPage<CategoryTreeVo> pageCategories(Page<Category> page, String specialLineId);

    List<CategoryTreeVo> menuCategories();

    List<Category> rootCategories();

    String getIdByCategoryName(String categoryName);

    Category getByName(String categoryName);

    void save(String categoryName);

    List<Category> getChildren(String parentId);

    List<Category> getAllChildren(String categoryId);

    CategoryTreeVo getVoById(String id);

    void changeAvailable(String id, Boolean available);

    String getRootCategoryName(String categoryId);

    void updateById(String id, Category category);

    void addCategory(Category category);

    List<KeyValue> listSpecialLines();

    Map<String, String> getNameIdDict(Set<String> categoryNames);


}
