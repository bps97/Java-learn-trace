package cn.bps.heam.dict;

import cn.bps.common.lang.annotation.Label;

public enum Column {
    @Label("分类")
    category,
    @Label("价格")
    price,
    @Label("属性值")
    attributeValue,
    @Label("商品名称")
    productName;
}
