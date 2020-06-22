package cn.bps.mms.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    private String id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 用戶類型
     */
    private String userType;

    /**
     * 角色类型
     */
    private String roleType;

    /**
     * 是否有效
     */
    private Boolean available;

    /**
     * 創建時間
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date updateTime;


}
