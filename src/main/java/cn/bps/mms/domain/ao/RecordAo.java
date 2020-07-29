package cn.bps.mms.domain.ao;

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
