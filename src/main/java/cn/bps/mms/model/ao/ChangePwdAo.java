package cn.bps.mms.model.ao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ChangePwdAo {
    private String password;
    private String newPassword;
}
