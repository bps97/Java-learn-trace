package cn.bps.mapper;

import cn.bps.pojo.Label;
import cn.bps.pojo.LabelExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface LabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Label record);

    int insertSelective(Label record);

    List<Label> selectByExampleWithRowbounds(LabelExample example, RowBounds rowBounds);

    List<Label> selectByExample(LabelExample example);

    Label selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);
}