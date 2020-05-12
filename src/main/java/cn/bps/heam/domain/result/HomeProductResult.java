package cn.bps.heam.domain.result;

import cn.bps.common.lang.annotation.Label;

import java.util.List;

@Label("首页推送产品块")
public class HomeProductResult {
    private String categoryName;

    private List<ProductResult> products;

    public List<ProductResult> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResult> products) {
        this.products = products;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
