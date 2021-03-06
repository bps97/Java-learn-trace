package cn.bps.mms.model.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApplicationItemVo {
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
     * 专业线编号(接入、无线、传输)
     */
    private String specialLine;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 类型(领用，归还，新品录入)
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
