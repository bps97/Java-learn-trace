package cn.bps.hea.service.impl;

import cn.bps.hea.mapper.ProductAttributeDictMapper;
import cn.bps.hea.domain.model.ProductAttributeDict;
import cn.bps.hea.domain.model.ProductAttributeDictExample;
import cn.bps.hea.service.ProductAttributeDictService;
import cn.bps.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductAttributeDictServiceImpl implements ProductAttributeDictService {


    @Autowired
    private ProductAttributeDictMapper attributeDictMapper;

    /**********************************************************************/

    @Override
    public Map<String, String> getAttributeDict(String productId) {

        ProductAttributeDictExample attributeDictExample = new ProductAttributeDictExample();
        attributeDictExample.createCriteria().andAvailableEqualTo(true).andProductIdEqualTo(productId);
        List<ProductAttributeDict> productAttributeDictList = attributeDictMapper.selectByExample(attributeDictExample);
        return productAttributeDictList
                .stream().collect(Collectors.toMap(ProductAttributeDict::getAttributeKey,ProductAttributeDict::getAttributeValue));
    }

    @Override
    public List<ProductAttributeDict> listProductAttributeDicts() {
        return attributeDictMapper.selectByExample(new ProductAttributeDictExample());
    }

    @Override
    public int saveProductAttributeDict(ProductAttributeDict dict) {
        int result = 0;
        try{
            result = attributeDictMapper.insert(dict);
        }catch (org.springframework.dao.DuplicateKeyException e){ // 如果key重复
            String newUUID = null;
            List<String> uuidList = listProductAttributeDicts().stream().map(ProductAttributeDict::getId).collect(Collectors.toList());
            do {
                newUUID = Generator.getUUID();
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
