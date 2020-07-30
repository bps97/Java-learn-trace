package cn.bps.mms.domain.ao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MaterialAo {
    private String categoryId;
    private String warehouseId;
    private String key;
}
