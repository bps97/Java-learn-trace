package cn.bps.pojo;

public class Label {
    private Integer id;

    private Integer label_category_id;

    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLabel_category_id() {
        return label_category_id;
    }

    public void setLabel_category_id(Integer label_category_id) {
        this.label_category_id = label_category_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}