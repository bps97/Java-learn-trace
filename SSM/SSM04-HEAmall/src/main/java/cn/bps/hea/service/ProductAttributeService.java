package cn.bps.hea.service;

import cn.bps.hea.domain.model.ProductCategory;
import cn.bps.hea.domain.model.ProductAttribute;

import java.util.List;

public interface ProductAttributeService {

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


}
