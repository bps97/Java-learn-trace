package cn.bps.heam.service.impl;


import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.domain.model.ProductAttributeDict;
import cn.bps.heam.domain.model.ProductAttributeDictExample;
import cn.bps.heam.domain.model.ProductAttributeExample;
import cn.bps.heam.mapper.ProductAttributeDictMapper;
import cn.bps.heam.service.ProductAttributeDictService;
import cn.bps.common.lang.util.Generator;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductAttributeDictServiceImpl implements ProductAttributeDictService {


    @Resource
    private ProductAttributeDictMapper attributeDictMapper;


/**********************************************************************/


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

