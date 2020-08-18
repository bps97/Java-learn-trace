package cn.bps.mms.model.ao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RecordAo {
    private String warehouseId;
    private String specialLines;

}
