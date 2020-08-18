package cn.bps.mms.model.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("申请单类型")
public class ApplicationType implements IApplication {
    @NotNull(message = "申请单类型不能为空")
    @ApiModelProperty(value = "申请单类型", required = true)
    private String type;
}
