package cn.bps.mms.model.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RecordTreeVo {

    /**
     * 编号
     */
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
     * 数量
     */
    private Integer count;

    /**
     * 类型(领用，归还，新品录入)
     */
    private String type;

    /**
     * 备注信息
     */
    private String message;

    /**
     * 子记录列表
     */
    private List<RecordTreeVo> children;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
