package cn.bps.mms.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AuthenticationVo {

    /**
     * 编号
     */
    private String id;

    /**
     * 权限名称
     */
    private String authName;

    /**
     * UI界面应用路径
     */
    private String path;

    /**
     * 子权限
     */
    private List<AuthenticationVo> children;

    /**
     * 序号
     */
    private Integer index;

    /**
     * 是否有效
     */
    private Boolean available;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date updateTime;

}
