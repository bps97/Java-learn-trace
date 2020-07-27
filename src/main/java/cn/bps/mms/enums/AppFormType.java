package cn.bps.mms.enums;

public enum AppFormType {

    excelImport("批量导入"),    /*批量录入*/
    recordUsage("记录所领用");   /*记录所领用*/

    private final String type;

    AppFormType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
