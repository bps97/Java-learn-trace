package cn.bps.hea.service.impl;

import cn.bps.hea.mapper.ProductAttributeMapper;
import cn.bps.hea.domain.model.ProductCategory;
import cn.bps.hea.domain.model.ProductAttribute;
import cn.bps.hea.domain.model.ProductAttributeExample;
import cn.bps.hea.service.ProductAttributeService;
import cn.bps.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {

    @Autowired
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
        int result = 0;
        try{
            result = productAttributeMapper.insert(attribute);
        }catch (org.springframework.dao.DuplicateKeyException e){ // 如果key重复
            String newUUID = null;
            List<String> uuidList = listProductAttributes().stream().map(ProductAttribute::getId).collect(Collectors.toList());
            do {
                newUUID = Generator.getUUID();
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
