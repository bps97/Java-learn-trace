package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.ResourceUri;
import cn.bps.heam.domain.model.ResourceUriExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ResourceUriMapper {
    long countByExample(ResourceUriExample example);

    int deleteByExample(ResourceUriExample example);

    int deleteByPrimaryKey(String id);

    int insert(ResourceUri record);

    int insertSelective(ResourceUri record);

    List<ResourceUri> selectByExampleWithBLOBsWithRowbounds(ResourceUriExample example, RowBounds rowBounds);

    List<ResourceUri> selectByExampleWithBLOBs(ResourceUriExample example);

    List<ResourceUri> selectByExampleWithRowbounds(ResourceUriExample example, RowBounds rowBounds);

    List<ResourceUri> selectByExample(ResourceUriExample example);

    ResourceUri selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ResourceUri record, @Param("example") ResourceUriExample example);

    int updateByExampleWithBLOBs(@Param("record") ResourceUri record, @Param("example") ResourceUriExample example);

    int updateByExample(@Param("record") ResourceUri record, @Param("example") ResourceUriExample example);

    int updateByPrimaryKeySelective(ResourceUri record);

    int updateByPrimaryKeyWithBLOBs(ResourceUri record);

    int updateByPrimaryKey(ResourceUri record);
}