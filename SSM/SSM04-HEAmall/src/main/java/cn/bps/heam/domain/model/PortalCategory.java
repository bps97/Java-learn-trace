package cn.bps.heam.domain.model;

public class PortalCategory {
    private String id;

    private String refCategoryId;

    private Integer portalIndex;

    private String categoryName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRefCategoryId() {
        return refCategoryId;
    }

    public void setRefCategoryId(String refCategoryId) {
        this.refCategoryId = refCategoryId == null ? null : refCategoryId.trim();
    }

    public Integer getPortalIndex() {
        return portalIndex;
    }

    public void setPortalIndex(Integer portalIndex) {
        this.portalIndex = portalIndex;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", refCategoryId=").append(refCategoryId);
        sb.append(", portalIndex=").append(portalIndex);
        sb.append(", categoryName=").append(categoryName);
        sb.append("]");
        return sb.toString();
    }
}