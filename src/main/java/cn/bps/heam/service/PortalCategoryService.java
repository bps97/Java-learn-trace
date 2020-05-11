package cn.bps.heam.service;

import cn.bps.heam.domain.model.PortalCategory;
import cn.bps.heam.domain.model.ProductCategory;

import java.util.List;
import java.util.Locale;

public interface PortalCategoryService {

    List<PortalCategory> listPortalCategories();

    int savePortalCategory(PortalCategory portalCategory);

    int savePortalCategory(ProductCategory productCategory);

    long count();
}