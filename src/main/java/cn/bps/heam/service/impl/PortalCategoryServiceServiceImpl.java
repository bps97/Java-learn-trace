package cn.bps.heam.service.impl;

import cn.bps.common.lang.util.Generator;
import cn.bps.heam.domain.model.PortalCategory;
import cn.bps.heam.domain.model.PortalCategoryExample;
import cn.bps.heam.domain.model.Product;
import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.heam.mapper.PortalCategoryMapper;
import cn.bps.heam.service.PortalCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PortalCategoryServiceServiceImpl implements PortalCategoryService {

    @Resource
    private PortalCategoryMapper categoryMapper;

    @Override
    public List<PortalCategory> listPortalCategories() {
        return categoryMapper.selectByExample(new PortalCategoryExample());
    }

    @Override
    public int savePortalCategory(PortalCategory portalCategory) {
        int result;
        try{
            result = categoryMapper.insert(portalCategory);
        }catch (org.springframework.dao.DuplicateKeyException e){ // 如果key重复
            String newUUID;
            List<String> uuidList = listPortalCategories().stream().map(PortalCategory::getId).collect(Collectors.toList());
            do {
                newUUID = Generator.getUUID();
            }while (uuidList.contains(newUUID));
            portalCategory.setId(newUUID);
            result = categoryMapper.insert(portalCategory);
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

        return categoryMapper.countByExample(new PortalCategoryExample());
    }
}
