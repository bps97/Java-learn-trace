package cn.bps.mms.domain.ao;

import cn.bps.mms.domain.IApplication;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApplicationAo implements IApplication {
    private String type;
    private String message;
}
