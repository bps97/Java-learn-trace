package cn.bps.heam.service;


import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.domain.model.ProductAttributeDict;
import cn.bps.heam.domain.model.ProductCategory;

import java.util.List;
import java.util.Map;

public interface AttributeService {

    /**
     * 根据分类id获取属性名列表
     * @return
     */
    List<ProductAttribute> listProductAttributes();

    List<ProductAttribute> listProductAttributes(ProductCategory category);

    List<ProductAttribute> listProductAttributes(String categoryId);

    /**
     * 保证插入数据uid唯一地插入attribute
     * @param attribute
     * @return
     */
    int saveProductAttribute(ProductAttribute attribute);

    /**
     * 保证前后ID一致地修改attribute
     * @param attribute
     * @return
     */
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

}
