package cn.bps.heam.service;


import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.domain.model.ProductAttributeDict;
import cn.bps.heam.domain.model.ProductCategory;

import java.util.List;
import java.util.Map;

public interface AttributeService {



    /***********************************************************************/

    List<ProductAttribute> listProductAttributes();

    List<ProductAttribute> listProductAttributes(ProductCategory category);

    List<ProductAttribute> listProductAttributes(String categoryId);

    int saveProductAttribute(ProductAttribute attribute);

    int updateProductAttribute(ProductAttribute attribute);


    /***********************************************************************/

    Map<String, String> getAttributeDict(String productId);

    List<ProductAttributeDict> listAttrDicts();

    List<ProductAttributeDict> listAttrDictByAttrIds(List<String> attrIds);

    List<ProductAttributeDict> listAttrDictByAttrId(String attrId);

    List<ProductAttributeDict> listAttrDictByIdDict(String attrId, String value);

    List<ProductAttributeDict> listAttrDictByDict(String key, String value);

    int saveAttributeDict(ProductAttributeDict dict);

    int updateAttributeDict(ProductAttributeDict dict);

    ProductAttribute getAttributeById(String attrId);

    void updateAttribute(ProductAttribute attribute);

    void deleteAttribute(String id);
}
