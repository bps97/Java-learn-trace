package cn.bps.pojo;

public class AdministrativeArea {
    private Integer id;

    private String code;

    private String name;

    private String parent_id;

    private String short_name;

    private Integer level_type;

    private String city_code;

    private String zip_code;

    private String merge_name;

    private String ing;

    private String lat;

    private String pinyin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id == null ? null : parent_id.trim();
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name == null ? null : short_name.trim();
    }

    public Integer getLevel_type() {
        return level_type;
    }

    public void setLevel_type(Integer level_type) {
        this.level_type = level_type;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code == null ? null : city_code.trim();
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code == null ? null : zip_code.trim();
    }

    public String getMerge_name() {
        return merge_name;
    }

    public void setMerge_name(String merge_name) {
        this.merge_name = merge_name == null ? null : merge_name.trim();
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing == null ? null : ing.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }
}