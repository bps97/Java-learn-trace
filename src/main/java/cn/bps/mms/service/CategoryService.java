package cn.bps.mms.service;

import cn.bps.mms.domain.vo.KeyValue;
import cn.bps.mms.entity.Category;
import cn.bps.mms.domain.vo.CategoryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 分类 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
public interface CategoryService extends IService<Category> {

    IPage<CategoryVo> pageCategories(Page<Category> page, String specialLineId);

    List<CategoryVo> menuCategories();

    List<Category> rootCategories();

    String getIdByCategoryName(String categoryName);

    Category getByName(String categoryName);

    void save(String categoryName);

    List<Category> getChildren(String parentId);

    CategoryVo getVoById(String id);

    void changeAvailable(String id, Boolean available);

    String getRootCategoryName(String categoryId);

    void updateById(String id, Category category);

    void addCategory(Category category);

    List<KeyValue> listSpecialLines();

}
