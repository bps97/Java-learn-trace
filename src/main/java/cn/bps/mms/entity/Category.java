package cn.bps.mms.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 分类
 * </p>
 *
 * @author bps
 * @since 2020-06-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Category implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 父分类ID
     */
    private String parentId;

    /**
     * 物料类型(消耗型物料,设备型物料)
     */
    private String type;

    /**
     * 是否有效
     */
    private Boolean available;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 最后修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
