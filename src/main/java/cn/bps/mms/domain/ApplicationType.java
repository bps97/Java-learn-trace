package cn.bps.mms.domain;

public enum ApplicationType {

    excelImport("批量入库"),    /*批量入库*/
    warehouseEntry("逐项入库"),   /*批量入库*/
    deliveryOfCargoFromStorage("逐项出库");   /*批量出库*/

    private final String type;

    ApplicationType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
