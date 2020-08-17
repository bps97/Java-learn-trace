package cn.bps.heam.biz.impl;

import cn.bps.common.lang.util.Generator;
import cn.bps.heam.biz.AttributeBiz;
import cn.bps.heam.domain.form.AttributeForm;
import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.domain.result.AttributeResult;
import cn.bps.heam.domain.result.AttributeTupleResult;
import cn.bps.heam.service.AttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AttributeBizImpl implements AttributeBiz {

    @Resource
    private AttributeService attributeService;

    @Override
    public AttributeTupleResult tupleAttributes(String categoryId) {
        AttributeTupleResult tupleResult = new AttributeTupleResult();
        tupleResult.setDynamic(listAttributes(categoryId,true));
        tupleResult.setImmutable(listAttributes(categoryId, false));
        return tupleResult;
    }

    @Override
    public List<AttributeResult> listAttributes(String categoryId, boolean dynamic) {
        return attributeService.listProductAttributes(categoryId).stream()
                .filter(e-> Objects.equals(dynamic,e.getDynamic()))
                .map(this::model2Result).collect(Collectors.toList());
    }

    @Override
    public List<AttributeResult> listAttributes(String categoryId) {
        return attributeService.listProductAttributes(categoryId).stream().map(this::model2Result).collect(Collectors.toList());
    }

    @Override
    public void saveAttribute(AttributeForm form) {
        ProductAttribute attribute = new ProductAttribute();
        attribute.setId(Generator.getUUID());
        attribute.setAvailable(Boolean.TRUE);
        attribute.setCategoryId(form.getCategoryId());
        attribute.setCreateTime(new Date());
        attribute.setDynamic(form.getDynamic());
        attribute.setUpdateTime(new Date());
        attribute.setAttributeName(form.getAttributeName());
        attributeService.saveProductAttribute(attribute);
    }

    @Override
    public AttributeResult queryAttributeById(String id) {
        return model2Result(attributeService.getAttributeById(id));
    }

    @Override
    public void updateAttribute(AttributeForm attributeForm) {
        ProductAttribute attribute = new ProductAttribute();
        attribute.setId(attributeForm.getId());
        attribute.setUpdateTime(new Date());
        attribute.setAttributeName(attributeForm.getAttributeName());
        attributeService.updateAttribute(attribute);
    }

    @Override
    public void removeAttribute(String id) {
        attributeService.deleteAttribute(id);
    }

    private AttributeResult model2Result(ProductAttribute attribute){
        AttributeResult result = new AttributeResult();
        result.setAttributeName(attribute.getAttributeName());
        result.setAvailable(attribute.getAvailable());
        result.setCategoryId(attribute.getCategoryId());
        result.setId(attribute.getId());
        return result;
    }

}
