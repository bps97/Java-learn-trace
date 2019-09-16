package cn.bps.mapper;

import cn.bps.pojo.AdministrativeArea;
import cn.bps.pojo.AdministrativeAreaExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface AdministrativeAreaMapper {
    List<AdministrativeArea> selectByExampleWithRowbounds(AdministrativeAreaExample example, RowBounds rowBounds);

    List<AdministrativeArea> selectByExample(AdministrativeAreaExample example);

    AdministrativeArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdministrativeArea record);

    int updateByPrimaryKey(AdministrativeArea record);
}