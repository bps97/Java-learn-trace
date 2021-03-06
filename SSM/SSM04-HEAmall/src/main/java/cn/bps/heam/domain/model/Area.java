package cn.bps.heam.domain.model;

import java.util.HashMap;

public class Area {

    private Integer id;

    private String code;

    private String name;

    private String parentId;

    private String shortName;

    private Integer levelType;

    private String cityCode;

    private String zipCode;

    private String mergeName;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public Integer getLevelType() {
        return levelType;
    }

    public void setLevelType(Integer levelType) {
        this.levelType = levelType;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getMergeName() {
        return mergeName;
    }

    public void setMergeName(String mergeName) {
        this.mergeName = mergeName == null ? null : mergeName.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", parentId=").append(parentId);
        sb.append(", shortName=").append(shortName);
        sb.append(", levelType=").append(levelType);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", zipCode=").append(zipCode);
        sb.append(", mergeName=").append(mergeName);
        sb.append(", ing=").append(ing);
        sb.append(", lat=").append(lat);
        sb.append(", pinyin=").append(pinyin);
        sb.append("]");
        return sb.toString();
    }

    public enum Level {
        COUNTRY("国家", 0),
        PROVINCE("省", 1),
        CITY("市", 2),
        DISTRICT("区县", 3);
        private static HashMap<Integer, Level> VALUES = new HashMap<>();
        static {
            for (Level l : Level.values()) {
                VALUES.put(l.val, l);
            }
        }
        public static Level resolve(int val) {
            return VALUES.get(val);
        }
        private String desc;
        private int val;
        Level(String desc, int val) {
            this.desc = desc;
        }
        public String getDesc() {
            return desc;
        }
        public int getVal() {
            return val;
        }
    }

}
