package cn.bps.heam.service.impl;

import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.heam.domain.model.ProductCategoryExample;
import cn.bps.heam.mapper.ProductCategoryMapper;
import cn.bps.heam.service.ProductCategoryService;
import cn.bps.common.lang.util.Generator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource
    private ProductCategoryMapper categoryMapper;


/**********************************************************************/


    public List<ProductCategory> listProductCategories() {
        return categoryMapper.selectByExample(new ProductCategoryExample());
    }


    @Override
    public int saveProductCategory(ProductCategory category) {

        int result;
        try{
            result = categoryMapper.insertSelective(category);
        }catch (org.springframework.dao.DuplicateKeyException e){ // 如果key重复
            String newUUID;
            List<String> uuidList = listProductCategories().stream().map(ProductCategory::getId).collect(Collectors.toList());
            do {
                newUUID = Generator.getUUID();
            }while (uuidList.contains(newUUID));
            category.setId(newUUID);
            result = categoryMapper.insertSelective(category);
        }
        return result;
    }

    @Override
    public int updateProductCategory(ProductCategory category) {
        return categoryMapper.updateByPrimaryKeySelective(category);
    }
}
