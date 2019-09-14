package cn.bps.pojo;

public class Address {
    private Integer id;

    private String receiver;

    private String mobile;

    private String province;

    private String prefecture;

    private String county;

    private String address;

    private Integer user_id;

    private Integer default_address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture == null ? null : prefecture.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getDefault_address() {
        return default_address;
    }

    public void setDefault_address(Integer default_address) {
        this.default_address = default_address;
    }
}