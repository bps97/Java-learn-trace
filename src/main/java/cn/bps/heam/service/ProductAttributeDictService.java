package cn.bps.heam.service;


import cn.bps.heam.domain.model.ProductAttributeDict;

import java.util.List;
import java.util.Map;

public interface ProductAttributeDictService {

    Map<String, String> getAttributeDict(String productId);

    List<ProductAttributeDict> listProductAttributeDicts();

    int saveProductAttributeDict(ProductAttributeDict dict);

    int updateProductAttributeDict(ProductAttributeDict dict);

}
