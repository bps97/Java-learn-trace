package cn.bps.heam.domain.model;

import java.util.Date;

public class Authentication {
    private String id;

    private String authName;

    private String path;

    private String parentId;

    private Integer portalIndex;

    private Boolean available;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName == null ? null : authName.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Integer getPortalIndex() {
        return portalIndex;
    }

    public void setPortalIndex(Integer portalIndex) {
        this.portalIndex = portalIndex;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", authName=").append(authName);
        sb.append(", path=").append(path);
        sb.append(", parentId=").append(parentId);
        sb.append(", portalIndex=").append(portalIndex);
        sb.append(", available=").append(available);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}