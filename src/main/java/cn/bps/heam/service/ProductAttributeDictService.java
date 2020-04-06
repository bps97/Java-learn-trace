package cn.bps.heam.service;


import cn.bps.heam.domain.model.ProductAttributeDict;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProductAttributeDictService {

    Map<String, String> getAttributeDict(String productId);

    List<ProductAttributeDict> listAttrDicts();

    List<ProductAttributeDict> listAttrDictByAttrIds(List<String> attrIds);

    List<ProductAttributeDict> listAttrDictByAttrId(String attrId);

    List<ProductAttributeDict> listAttrDictByIdDict(String attrId, String value);

    List<ProductAttributeDict> listAttrDictByDict(String key, String value);

    int saveAttributeDict(ProductAttributeDict dict);

    int updateAttributeDict(ProductAttributeDict dict);

}
