package cn.bps.mms.model.pojo;

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
 * 物料
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Material implements Serializable {

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
     * 分类编号
     */
    private String categoryId;

    /**
     * 仓库编号
     */
    private String warehouseId;

    /**
     * 专业线编号(接入、无线、传输)
     */
    private String specialLine;

    /**
     * 使用状态(正常|损坏)
     */
    private String status;

    /**
     * 数量
     */
    private Integer count;

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
