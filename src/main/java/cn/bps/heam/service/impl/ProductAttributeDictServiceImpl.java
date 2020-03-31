package cn.bps.heam.service.impl;


import cn.bps.heam.domain.model.ProductAttributeDict;
import cn.bps.heam.domain.model.ProductAttributeDictExample;
import cn.bps.heam.mapper.ProductAttributeDictMapper;
import cn.bps.heam.service.ProductAttributeDictService;
import cn.bps.heam.util.UtilGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
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
    public List<ProductAttributeDict> listProductAttributeDicts() {
        return attributeDictMapper.selectByExample(new ProductAttributeDictExample());
    }

    @Override
    public int saveProductAttributeDict(ProductAttributeDict dict) {
        int result;
        try{
            result = attributeDictMapper.insert(dict);
        }catch (org.springframework.dao.DuplicateKeyException e){ // 如果key重复
            String newUUID;
            List<String> uuidList = listProductAttributeDicts().stream().map(ProductAttributeDict::getId).collect(Collectors.toList());
            do {
                newUUID = UtilGenerator.getUUID();
            }while (uuidList.contains(newUUID));
            dict.setId(newUUID);
            result = attributeDictMapper.insert(dict);
        }
        return result;
    }

    @Override
    public int updateProductAttributeDict(ProductAttributeDict dict) {
        return 0;
    }
}

