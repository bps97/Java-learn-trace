package cn.bps.heam.domain.model;

import java.math.BigDecimal;

public class ProductPackage extends ProductPackageKey {
    private String serviceId;

    private BigDecimal price;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serviceId=").append(serviceId);
        sb.append(", price=").append(price);
        sb.append("]");
        return sb.toString();
    }
}