package cn.bps.heam.domain.model;

import java.util.Date;

public class Commercial {
    private String id;

    private String info;

    private String imgUriId;

    private Integer portalIndex;

    private String point;

    private Boolean available;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getImgUriId() {
        return imgUriId;
    }

    public void setImgUriId(String imgUriId) {
        this.imgUriId = imgUriId == null ? null : imgUriId.trim();
    }

    public Integer getPortalIndex() {
        return portalIndex;
    }

    public void setPortalIndex(Integer portalIndex) {
        this.portalIndex = portalIndex;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point == null ? null : point.trim();
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", info=").append(info);
        sb.append(", imgUriId=").append(imgUriId);
        sb.append(", portalIndex=").append(portalIndex);
        sb.append(", point=").append(point);
        sb.append(", available=").append(available);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}