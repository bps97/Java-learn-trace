package cn.bps.mapper;

import cn.bps.pojo.ScrollAd;
import cn.bps.pojo.ScrollAdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ScrollAdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScrollAd record);

    int insertSelective(ScrollAd record);

    List<ScrollAd> selectByExampleWithRowbounds(ScrollAdExample example, RowBounds rowBounds);

    List<ScrollAd> selectByExample(ScrollAdExample example);

    ScrollAd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScrollAd record, @Param("example") ScrollAdExample example);

    int updateByExample(@Param("record") ScrollAd record, @Param("example") ScrollAdExample example);

    int updateByPrimaryKeySelective(ScrollAd record);

    int updateByPrimaryKey(ScrollAd record);
}