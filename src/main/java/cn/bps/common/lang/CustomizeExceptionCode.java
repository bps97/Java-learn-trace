package cn.bps.common.lang;

public enum CustomizeExceptionCode {

    NAME_ALREADY_EXIST("name already exist","名称已经存在"),
    COMMERCIAL_NOT_EXIST("commercial not exist","广告不存在"),
    CATEGORY_NOT_EXIST("category not exist","分类不存在"),
    ACCOUNT_NOT_EXIST("account not exit", "账户不存在"),
    PASSWORD_NOT_INCORRECT("password not incorrect", "密码错误");

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
