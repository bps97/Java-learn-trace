package cn.bps.mms.service;

import cn.bps.common.lang.api.Page;
import cn.bps.mms.domain.PageRequest;
import cn.bps.mms.entity.Category;
import cn.bps.mms.domian.vo.CategoryVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 分类项 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
public interface CategoryService extends IService<Category> {

    Page<CategoryVo> pageCategories(PageRequest pageRequest);

    Page<CategoryVo> pageCategories(PageRequest pageRequest, Integer level);

    List<CategoryVo> listCategories();

    List<CategoryVo> listCategories(Integer level);

    List<CategoryVo> listCategories(boolean available);

    List<Category> rootCategories();

    String getId(String categoryName);

    Category getByName(String categoryName);

    void save(String categoryName);

    List<Category> getChildren(String parentId);

    CategoryVo getVoById(String id);

    void changeAvailable(String id, Boolean available);

    String getRootCategoryName(String categoryId);
}
