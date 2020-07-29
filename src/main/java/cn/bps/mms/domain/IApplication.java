package cn.bps.mms.domain;

public interface IApplication {
    String getType();
    default   ApplicationType getEnum(){
        switch(this.getType()){
            case "批量入库":
                return ApplicationType.excelImport;
            case "逐项入库":
                return ApplicationType.warehouseEntry;
            case "逐项出库":
                return ApplicationType.deliveryOfCargoFromStorage;
            default:
                return null;
        }
    }
}
