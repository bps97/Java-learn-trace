package cn.bps.mms.domain.ao;

import cn.bps.mms.enums.AppFormType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AppFormAo {
    private String type;
    public AppFormType getEnum(){
        switch(this.type){
            case "批量导入":
                return AppFormType.excelImport;
            case "记录所领用":
                return AppFormType.recordUsage;
            default:
                return null;
        }
    }
}
