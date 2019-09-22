package cn.bps.mapper;

import cn.bps.pojo.LabelCategory;
import cn.bps.pojo.LabelCategoryExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface LabelCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LabelCategory record);

    int insertSelective(LabelCategory record);

    List<LabelCategory> selectByExampleWithRowbounds(LabelCategoryExample example, RowBounds rowBounds);

    List<LabelCategory> selectByExample(LabelCategoryExample example);

    LabelCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LabelCategory record);

    int updateByPrimaryKey(LabelCategory record);
}