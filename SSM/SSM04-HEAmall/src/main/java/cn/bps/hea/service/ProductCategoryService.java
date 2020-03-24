package cn.bps.hea.service;

import cn.bps.hea.domain.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {


    List<ProductCategory> listProductCategories();


    int saveProductCategory(ProductCategory category);

    int updateProductCategory(ProductCategory category);



}
