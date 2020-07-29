package cn.bps.mms.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 仓库
 * </p>
 *
 * @author bps
 * @since 2020-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Warehouse implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 具体住址
     */
    private String address;

    /**
     * 父分类ID
     */
    private String parentId;

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
