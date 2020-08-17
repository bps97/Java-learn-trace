package cn.bps.heam.domain.model;

import java.util.Date;

public class Address {
    private String id;

    private String receiver;

    private String cellphoneNum;

    private String provinceCode;

    private String prefectureCode;

    private String countyCode;

    private String address;

    private String userId;

    private Boolean addressIsDefault;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getCellphoneNum() {
        return cellphoneNum;
    }

    public void setCellphoneNum(String cellphoneNum) {
        this.cellphoneNum = cellphoneNum == null ? null : cellphoneNum.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getPrefectureCode() {
        return prefectureCode;
    }

    public void setPrefectureCode(String prefectureCode) {
        this.prefectureCode = prefectureCode == null ? null : prefectureCode.trim();
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Boolean getAddressIsDefault() {
        return addressIsDefault;
    }

    public void setAddressIsDefault(Boolean addressIsDefault) {
        this.addressIsDefault = addressIsDefault;
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
        sb.append(", receiver=").append(receiver);
        sb.append(", cellphoneNum=").append(cellphoneNum);
        sb.append(", provinceCode=").append(provinceCode);
        sb.append(", prefectureCode=").append(prefectureCode);
        sb.append(", countyCode=").append(countyCode);
        sb.append(", address=").append(address);
        sb.append(", userId=").append(userId);
        sb.append(", addressIsDefault=").append(addressIsDefault);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}