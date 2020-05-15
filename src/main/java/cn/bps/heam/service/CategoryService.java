package cn.bps.heam.service;


import cn.bps.heam.domain.model.PortalCategory;
import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.heam.domain.model.ProductCategoryExample;
import cn.bps.heam.domain.model.ProductExample;

import java.util.List;

public interface CategoryService {

    /*product*/

    List<ProductCategory> listProductCategories();

    String getCategoryId(String categoryName);

    ProductCategory getCategoryByName(String categoryName);

    void saveProductCategory(ProductCategory category);

    void updateProductCategory(ProductCategory category);

    /*portal*/

    List<PortalCategory> listPortalCategories();

    void savePortalCategory(PortalCategory portalCategory);

    void savePortalCategory(ProductCategory productCategory);

    void savePortalCategory(String categoryName);

    long countPortalCategory();

    long countProductCategory();

    long countProductCategory(ProductCategoryExample example);


}
