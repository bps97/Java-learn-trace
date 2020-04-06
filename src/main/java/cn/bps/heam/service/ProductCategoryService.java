package cn.bps.heam.service;


import cn.bps.heam.domain.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {


    List<ProductCategory> listProductCategories();

    String getId(String categoryName);

    ProductCategory getCategoryByName(String categoryName);

    int saveProductCategory(ProductCategory category);

    int updateProductCategory(ProductCategory category);



}
