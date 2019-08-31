package cn.bps.pojo;

public class FilterValue {
    private Integer id;

    private Integer product_id;

    private Integer filter_id;

    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getFilter_id() {
        return filter_id;
    }

    public void setFilter_id(Integer filter_id) {
        this.filter_id = filter_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}