package cn.bps.mms.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MaterialVo {

    /**
     * 编号
     */
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
     * 分类名称
     */
    private String categoryName;

    /**
     * 仓库编号
     */
    private String repositoryId;

    /**
     * 仓库名称
     */
    private String repositoryName;

    /**
     * 专业线名称(接入、无线、传输)
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

}
