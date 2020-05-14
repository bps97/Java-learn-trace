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
        if(Objects.isNull(list) || list.isEmpty())
            throw new LocalBizServiceException(CustomizeExceptionCode.CATEGORY_NOT_EXIST,categoryName);
        return list.get(0);
    }


    @Override
    public int saveProductCategory(ProductCategory category) {

        int result;
        try{
            result = productCategoryMapper.insertSelective(category);
        }catch (org.springframework.dao.DuplicateKeyException e){ // 如果key重复
            String newUUID;
            List<String> uuidList = listProductCategories().stream().map(ProductCategory::getId).collect(Collectors.toList());
            do {
                newUUID = Generator.getUUID();
            }while (uuidList.contains(newUUID));
            category.setId(newUUID);
            result = productCategoryMapper.insertSelective(category);
        }
        return result;
    }

    @Override
    public int updateProductCategory(ProductCategory category) {
        return productCategoryMapper.updateByPrimaryKeySelective(category);
    }


    /******************************************************************/

    @Override
    public List<PortalCategory> listPortalCategories() {
        return portalCategoryMapper.selectByExample(new PortalCategoryExample());
    }

    @Override
    public int savePortalCategory(PortalCategory portalCategory) {
        int result;
        try{
            result = portalCategoryMapper.insert(portalCategory);
        }catch (org.springframework.dao.DuplicateKeyException e){ // 如果key重复
            String newUUID;
            List<String> uuidList = listPortalCategories().stream().map(PortalCategory::getId).collect(Collectors.toList());
            do {
                newUUID = Generator.getUUID();
            }while (uuidList.contains(newUUID));
            portalCategory.setId(newUUID);
            result = portalCategoryMapper.insert(portalCategory);
        }
        return result;
    }

    @Override
    public int savePortalCategory(ProductCategory productCategory) {
        PortalCategory portalCategory = new PortalCategory();
        portalCategory.setCategoryName(productCategory.getCategoryName());
        portalCategory.setPortalIndex((int)count()+1);
        portalCategory.setRefCategoryId(productCategory.getId());
        portalCategory.setId(Generator.getUUID());
        return savePortalCategory(portalCategory);
    }

    @Override
    public long count() {

        return portalCategoryMapper.countByExample(new PortalCategoryExample());
    }


}
