package cn.bps.hea.domain.model;

public class ProductPackageKey {
    private String id;

    private String productInstanceId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProductInstanceId() {
        return productInstanceId;
    }

    public void setProductInstanceId(String productInstanceId) {
        this.productInstanceId = productInstanceId == null ? null : productInstanceId.trim();
    }
}