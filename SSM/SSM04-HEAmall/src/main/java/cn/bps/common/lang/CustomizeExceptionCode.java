package cn.bps.common.lang;

public enum CustomizeExceptionCode {

    NAME_ALREADY_EXIST("name already exist","名称已经存在"),
    COMMERCIAL_NOT_EXIST("commercial not exist","广告不存在"),
    CATEGORY_NOT_EXIST("category not exist","分类不存在"),
    ACCOUNT_NOT_EXIST("account not exit", "账户不存在"),
    AUTHENTICATION_NOT_EXIST("authentication not exit", "权限不存在"),
    PASSWORD_NOT_INCORRECT("password not incorrect", "密码错误"),
    INSERT_DATA_FAIL("insert data fail", "插入数据失败"),
    UPDATE_FAIL("update data fail", "更新数据失败"),
    DELETE_FAIL("delete data fail", "删除数据失败"),
    AREA_REGION_TYPE_DOES_NOT_EXIST("Area region type does not exist.","区域级别类型不存在.");

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
