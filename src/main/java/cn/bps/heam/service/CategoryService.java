package cn.bps.heam.service;


import cn.bps.heam.domain.model.PortalCategory;
import cn.bps.heam.domain.model.ProductCategory;

import java.util.List;

public interface CategoryService {

    /*product*/

    List<ProductCategory> listProductCategories();

    String getCategoryId(String categoryName);

    ProductCategory getCategoryByName(String categoryName);

    int saveProductCategory(ProductCategory category);

    int updateProductCategory(ProductCategory category);

    /*portal*/

    List<PortalCategory> listPortalCategories();

    int savePortalCategory(PortalCategory portalCategory);

    int savePortalCategory(ProductCategory productCategory);

    long count();

}
