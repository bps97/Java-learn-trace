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
 * 申请单项
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApplicationItem implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 物料名称
     */
    private String materialName;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 物料ID
     */
    private String materialId;

    /**
     * 仓库ID
     */
    private String warehouseId;

    /**
     * 分离ID
     */
    private String categoryId;

    /**
     * 申请单ID
     */
    private String applicationId;

    /**
     * 使用状态(正常|损坏)
     */
    private String status;

    /**
     * 专业线编号(接入、无线、传输)
     */
    private String specialLine;

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
