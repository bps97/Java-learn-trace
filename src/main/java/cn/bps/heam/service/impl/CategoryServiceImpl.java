package cn.bps.heam.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.heam.domain.model.PortalCategory;
import cn.bps.heam.domain.model.PortalCategoryExample;
import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.heam.domain.model.ProductCategoryExample;
import cn.bps.heam.mapper.PortalCategoryMapper;
import cn.bps.heam.mapper.ProductCategoryMapper;
import cn.bps.heam.service.CategoryService;
import cn.bps.common.lang.util.Generator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Resource
    private PortalCategoryMapper portalCategoryMapper;


    /**********************************************************************/


    public List<ProductCategory> listProductCategories() {
        return productCategoryMapper.selectByExample(new ProductCategoryExample());
    }

    @Override
    public String getCategoryId(String categoryName) {
        return getCategoryByName(categoryName).getId();
    }

    @Override
    public ProductCategory getCategoryByName(String categoryName) {
        ProductCategoryExample example = new ProductCategoryExample();
        example.createCriteria().andCategoryNameEqualTo(categoryName);
        List<ProductCategory> list = productCategoryMapper.selectByExample(example);
        if (Objects.isNull(list) || list.isEmpty())
            throw new LocalBizServiceException(CustomizeExceptionCode.CATEGORY_NOT_EXIST, categoryName);
        return list.get(0);
    }


    @Override
    public void saveProductCategory(ProductCategory category) {

        int result;
        try {
            result = productCategoryMapper.insertSelective(category);
        } catch (org.springframework.dao.DuplicateKeyException e) { // 如果key重复
            String newUUID = getNewUuid();
            category.setId(newUUID);
            result = productCategoryMapper.insertSelective(category);
        }
        if (result != 1)
            throw new LocalBizServiceException(CustomizeExceptionCode.INSERT_DATA_FAIL);;
    }

    private String getNewUuid() {
        String newUUID;
        long count = 0L;
        do {
            newUUID = Generator.getUUID();
            ProductCategoryExample productCategoryExample = new ProductCategoryExample();
            productCategoryExample.createCriteria().andIdEqualTo(newUUID);
            count = countProductCategory(productCategoryExample);
        } while (count == 1);
        return newUUID;
    }

    @Override
    public void updateProductCategory(ProductCategory category) {
        int result = productCategoryMapper.updateByPrimaryKeySelective(category);
        if (result != 1)
            throw new LocalBizServiceException(CustomizeExceptionCode.UPDATE_FAIL);
    }


    /******************************************************************/

    @Override
    public List<PortalCategory> listPortalCategories() {
        return portalCategoryMapper.selectByExample(new PortalCategoryExample());
    }

    @Override
    public void savePortalCategory(PortalCategory portalCategory) {
        int result;
        try {
            result = portalCategoryMapper.insert(portalCategory);
        } catch (org.springframework.dao.DuplicateKeyException e) { // 如果key重复
            String newUUID;
            List<String> uuidList = listPortalCategories().stream().map(PortalCategory::getId).collect(Collectors.toList());
            do {
                newUUID = Generator.getUUID();
            } while (uuidList.contains(newUUID));
            portalCategory.setId(newUUID);
            result = portalCategoryMapper.insert(portalCategory);
        }
        if (result != 1)
            throw new LocalBizServiceException(CustomizeExceptionCode.INSERT_DATA_FAIL);
    }

    @Override
    public void savePortalCategory(ProductCategory productCategory) {
        savePortalCategory(product2Portal(productCategory));
    }

    private PortalCategory product2Portal(ProductCategory productCategory) {
        PortalCategory portalCategory = new PortalCategory();
        portalCategory.setCategoryName(productCategory.getCategoryName());
        portalCategory.setPortalIndex((int) countPortalCategory() + 1);
        portalCategory.setRefCategoryId(productCategory.getId());
        portalCategory.setId(Generator.getUUID());
        return portalCategory;
    }

    @Override
    public void savePortalCategory(String categoryName) {
        ProductCategory productCategory = getCategoryByName(categoryName);
        savePortalCategory(productCategory);
    }

    @Override
    public long countPortalCategory() {
        return portalCategoryMapper.countByExample(new PortalCategoryExample());
    }

    @Override
    public long countProductCategory() {
        return countProductCategory(new ProductCategoryExample());
    }

    @Override
    public long countProductCategory(ProductCategoryExample example) {
        return productCategoryMapper.countByExample(example);
    }


}
