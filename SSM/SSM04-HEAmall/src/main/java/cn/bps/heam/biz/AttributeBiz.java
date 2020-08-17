package cn.bps.heam.biz;

import cn.bps.heam.domain.form.AttributeForm;
import cn.bps.heam.domain.result.AttributeResult;
import cn.bps.heam.domain.result.AttributeTupleResult;

import java.util.List;

public interface AttributeBiz {

    AttributeTupleResult tupleAttributes(String categoryId);

    List<AttributeResult> listAttributes(String categoryId, boolean dynamic);

    List<AttributeResult> listAttributes(String categoryId);

    void saveAttribute(AttributeForm form);

    AttributeResult queryAttributeById(String id);

    void updateAttribute(AttributeForm attributeForm);

    void removeAttribute(String id);


}
