package cn.bps.mms.model.ao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApplicationItemAo implements IApplication {
    private String materialName;
    private String materialId;
    private String warehouseId;
    private String warehouseName;
    private String categoryId;
    private String specialLineId;
    private String status;
    private Integer count;
    private String type;
}
