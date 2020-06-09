package cn.bps.mms.vo;

import cn.bps.mms.entity.SpecialLine;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CategoryVo {

    /**
     * 编号
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 专业线编号(接入、无线、传输)
     */
    private SpecialLine specialLine;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 父分类ID
     */
    private List<CategoryVo> children;

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
