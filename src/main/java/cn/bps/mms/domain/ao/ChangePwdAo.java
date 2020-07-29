package cn.bps.mms.domain.ao;

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
