package cn.bps.hea.domain.model;

public class PortalCategory {
    private String id;

    private String refCategoryId;

    private Byte portalIndex;

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

    public Byte getPortalIndex() {
        return portalIndex;
    }

    public void setPortalIndex(Byte portalIndex) {
        this.portalIndex = portalIndex;
    }
}