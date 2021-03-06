package cn.bps.heam.domain.model;

import java.math.BigDecimal;

public class Price {

    private BigDecimal wight;

    private String id;

    private Integer type;

    private BigDecimal price;

    private String productId;

    private String serviceId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public BigDecimal getWight() {
        return wight;
    }

    public void setWight(BigDecimal wight) {
        this.wight = wight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append(", productId=").append(productId);
        sb.append(", serviceId=").append(serviceId);
        sb.append("]");
        return sb.toString();
    }

    public enum Type {
        PRODUCT(0),
        SERVICE(1);
        static Type[] TYPES = { PRODUCT, SERVICE };
        private int value;
        Type(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
        public Type resolve(int value) {
            return value >= 0 && value < TYPES.length ? TYPES[value] : null;
        }
    }

}
