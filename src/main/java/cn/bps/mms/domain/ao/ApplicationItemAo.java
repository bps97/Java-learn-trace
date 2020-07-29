package cn.bps.mms.domain.ao;

import cn.bps.mms.domain.IApplication;
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
    private String categoryId;
    private String status;
    private String specialLine;
    private Integer count;
    private String type;
}
