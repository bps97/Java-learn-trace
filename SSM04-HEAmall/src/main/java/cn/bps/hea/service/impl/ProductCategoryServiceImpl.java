package cn.bps.hea.service.impl;

import cn.bps.hea.mapper.ProductCategoryMapper;
import cn.bps.hea.domain.model.ProductCategory;
import cn.bps.hea.domain.model.ProductCategoryExample;
import cn.bps.hea.service.ProductCategoryService;
import cn.bps.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper categoryMapper;

    public List<ProductCategory> listProductCategories() {
        return categoryMapper.selectByExample(new ProductCategoryExample());
    }


    @Override
    public int saveProductCategory(ProductCategory category) {

        int result = 0;
        try{
            result = categoryMapper.insertSelective(category);
        }catch (org.springframework.dao.DuplicateKeyException e){ // 如果key重复
            String newUUID = null;
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
