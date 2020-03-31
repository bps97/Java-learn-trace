package cn.bps.heam.service.impl;


import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.domain.model.ProductAttributeExample;
import cn.bps.heam.domain.model.ProductCategory;
import cn.bps.heam.mapper.ProductAttributeMapper;
import cn.bps.heam.service.ProductAttributeService;
import cn.bps.heam.util.UtilGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {

    @Resource
    private ProductAttributeMapper productAttributeMapper;

/**********************************************************************/


    @Override
    public List<ProductAttribute> listProductAttributes() {
        return productAttributeMapper.selectByExample(new ProductAttributeExample());
    }

    @Override
    public List<ProductAttribute> listProductAttributes(ProductCategory category) {
        return listProductAttributes(category.getId());
    }

    @Override
    public List<ProductAttribute> listProductAttributes(String categoryId) {
        ProductAttributeExample productAttributeExample = new ProductAttributeExample();
        productAttributeExample.createCriteria().andAvailableEqualTo(true).andCategoryIdEqualTo(categoryId);
        return productAttributeMapper.selectByExample(productAttributeExample);

    }


    @Override
    public int saveProductAttribute(ProductAttribute attribute) {
        int result; // default=0
        try{
            result = productAttributeMapper.insert(attribute);
        }catch (org.springframework.dao.DuplicateKeyException e){ // 如果key重复
            String newUUID;
            List<String> uuidList = listProductAttributes().stream().map(ProductAttribute::getId).collect(Collectors.toList());
            do {
                newUUID = UtilGenerator.getUUID();
            }while (uuidList.contains(newUUID));
            attribute.setId(newUUID);
            result = productAttributeMapper.insert(attribute);
        }
        return result;
    }


    @Override
    public int updateProductAttribute(ProductAttribute attribute) {
        return productAttributeMapper.updateByPrimaryKeySelective(attribute);
    }
}
