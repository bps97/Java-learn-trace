package cn.bps.mms.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MenuItemVo {

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
    private List<MenuItemVo> children;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

}
