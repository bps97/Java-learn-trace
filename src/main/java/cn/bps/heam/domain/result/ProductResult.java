package cn.bps.heam.domain.result;

import cn.bps.common.lang.annotation.Label;

import java.math.BigDecimal;

public class ProductResult {
    private String name;

    @Label("USP(Unique Selling Proposition)")private String usp;

    private BigDecimal price;

    @Label("产品ID对应uri")private String uri;

    private String img;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsp() {
        return usp;
    }

    public void setUsp(String usp) {
        this.usp = usp;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
