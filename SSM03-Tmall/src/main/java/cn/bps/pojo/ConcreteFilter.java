package cn.bps.pojo;

public class ConcreteFilter {
    private Integer id;

    private Integer filter_case_id;

    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFilter_case_id() {
        return filter_case_id;
    }

    public void setFilter_case_id(Integer filter_case_id) {
        this.filter_case_id = filter_case_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}