package cn.bps.heam.service.impl;


import cn.bps.heam.domain.form.AttributeForm;
import cn.bps.heam.domain.result.AttributeResult;
import cn.bps.heam.domain.result.AttributeTupleResult;
import cn.bps.heam.domain.model.*;
import cn.bps.heam.mapper.ProductAttributeDictMapper;
import cn.bps.heam.mapper.ProductAttributeMapper;
import cn.bps.heam.service.AttributeService;
import cn.bps.common.lang.util.Generator;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class AttributeServiceImpl implements AttributeService {

    @Resource
    private ProductAttributeMapper productAttributeMapper;

    @Resource
    private ProductAttributeDictMapper attributeDictMapper;



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

    /**************************************************************************/

    @Override
    public Map<String, String> getAttributeDict(String productId) {

        ProductAttributeDictExample attributeDictExample = new ProductAttributeDictExample();
        attributeDictExample.createCriteria().andAvailableEqualTo(true).andProductIdEqualTo(productId);
        List<ProductAttributeDict> productAttributeDictList = attributeDictMapper.selectByExample(attributeDictExample);
        return productAttributeDictList
                .stream().collect(Collectors.toMap(ProductAttributeDict::getAttributeKey, ProductAttributeDict::getAttributeValue));
    }

    @Override
    public List<ProductAttributeDict> listAttrDicts() {
        return attributeDictMapper.selectByExample(new ProductAttributeDictExample());
    }

    @Override
    public List<ProductAttributeDict> listAttrDictByAttrIds(List<String> attrIds) {
        ProductAttributeDictExample example = new ProductAttributeDictExample();
        example.createCriteria().andAttributeIdIn(attrIds).andAvailableEqualTo(true);
        List<ProductAttributeDict> list = attributeDictMapper.selectByExample(example);
        return Objects.nonNull(list) ? list : Lists.newArrayList();
    }

    @Override
    public List<ProductAttributeDict> listAttrDictByAttrId(String attrId) {
        ProductAttributeDictExample example = new ProductAttributeDictExample();
        example.createCriteria().andAttributeIdEqualTo(attrId).andAvailableEqualTo(true);
        List<ProductAttributeDict> list = attributeDictMapper.selectByExample(example);
        return Objects.nonNull(list) ? list : Lists.newArrayList();
    }

    @Override
    public List<ProductAttributeDict> listAttrDictByIdDict(String attrId, String value) {
        ProductAttributeDictExample example = new ProductAttributeDictExample();
        example.createCriteria().andAttributeIdEqualTo(attrId).andAttributeValueEqualTo(value).andAvailableEqualTo(true);
        List<ProductAttributeDict> list = attributeDictMapper.selectByExample(example);
        return Objects.nonNull(list) ? list : Lists.newArrayList();
    }

    @Override
    public List<ProductAttributeDict> listAttrDictByDict(String key, String value) {
        ProductAttributeDictExample example = new ProductAttributeDictExample();
        example.createCriteria().andAttributeKeyEqualTo(key).andAttributeValueEqualTo(value).andAvailableEqualTo(true);
        List<ProductAttributeDict> list = attributeDictMapper.selectByExample(example);
        return Objects.nonNull(list) ? list : Lists.newArrayList();
    }

    @Override
    public int saveAttributeDict(ProductAttributeDict dict) {
        int result;
        try{
            result = attributeDictMapper.insert(dict);
        }catch (org.springframework.dao.DuplicateKeyException e){ // 如果key重复
            String newUUID;
            List<String> uuidList = this.listAttrDicts().stream().map(ProductAttributeDict::getId).collect(Collectors.toList());
            do {
                newUUID = Generator.getUUID();
            }while (uuidList.contains(newUUID));
            dict.setId(newUUID);
            result = attributeDictMapper.insert(dict);
        }
        return result;
    }

    @Override
    public int updateAttributeDict(ProductAttributeDict dict) {
        return 0;
    }
}
