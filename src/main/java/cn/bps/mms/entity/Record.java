package cn.bps.mms.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 记录信息
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Record implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 物料使用人员
     */
    private String userName;

    /**
     * 物料名称
     */
    private String materialName;

    /**
     * 使用状态(正常|损坏)
     */
    private String status;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 专业线
     */
    private String specialLine;

    /**
     * 编号
     */
    private String userId;

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
     * 数量
     */
    private Integer count;

    /**
     * 类型(领用，归还，新品录入)
     */
    private String type;

    /**
     * 父记录ID
     */
    private String parentId;

    /**
     * 备注信息
     */
    private String message;

    /**
     * 是否有效
     */
    private Boolean available;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
