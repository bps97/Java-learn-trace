package cn.bps.common.lang;

public enum CustomizeExceptionCode {

    NAME_ALREADY_EXIST("name_already_exist","名称已经存在"),

    COMMERCIAL_NOT_EXIST("commercial_not_exist","广告不存在"),
    CATEGORY_NOT_EXIST("category_not_exist","分类不存在");

    private final String name;
    private final String info;

    CustomizeExceptionCode(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}
