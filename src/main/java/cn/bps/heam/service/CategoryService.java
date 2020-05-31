package cn.bps.heam.service;


import cn.bps.common.lang.api.Page;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.PortalCategory;
import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.heam.domain.model.ProductCategoryExample;
import cn.bps.heam.domain.result.CategoryResult;

import java.util.List;

public interface CategoryService {


    /*result*/

    Page<CategoryResult> pageCategories(PageRequest pageRequest);

    List<CategoryResult> listCategories();

    /*product*/

    List<ProductCategory> listProductCategories();

    String getCategoryId(String categoryName);

    ProductCategory getCategoryByName(String categoryName);

    void saveProductCategory(ProductCategory category);

    void saveProductCategory(String categoryName);

    void updateProductCategory(ProductCategory category);

    void removeProductCategory(String id);

    /*portal*/

    List<PortalCategory> listPortalCategories();

    void savePortalCategory(PortalCategory portalCategory);

    void savePortalCategory(ProductCategory productCategory);

    void savePortalCategory(String categoryName);

    long countPortalCategory();

    long countProductCategory();

    long countProductCategory(ProductCategoryExample example);


}
