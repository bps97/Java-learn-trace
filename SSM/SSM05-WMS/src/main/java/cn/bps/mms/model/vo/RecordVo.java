package cn.bps.mms.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RecordVo {
    private String id;
    private String userName;
    private String message;
    private String type;
    private String count;
    private Date updateTime;
}
