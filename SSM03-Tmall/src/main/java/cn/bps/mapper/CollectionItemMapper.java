package cn.bps.mapper;

import cn.bps.pojo.CollectionItem;
import cn.bps.pojo.CollectionItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CollectionItemMapper {
    long countByExample(CollectionItemExample example);

    int deleteByExample(CollectionItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CollectionItem record);

    int insertSelective(CollectionItem record);

    List<CollectionItem> selectByExampleWithRowbounds(CollectionItemExample example, RowBounds rowBounds);

    List<CollectionItem> selectByExample(CollectionItemExample example);

    CollectionItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CollectionItem record, @Param("example") CollectionItemExample example);

    int updateByExample(@Param("record") CollectionItem record, @Param("example") CollectionItemExample example);

    int updateByPrimaryKeySelective(CollectionItem record);

    int updateByPrimaryKey(CollectionItem record);
}