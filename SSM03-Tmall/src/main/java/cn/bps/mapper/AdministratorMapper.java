package cn.bps.mapper;

import cn.bps.pojo.Administrator;
import cn.bps.pojo.AdministratorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AdministratorMapper {
    long countByExample(AdministratorExample example);

    int deleteByExample(AdministratorExample example);

    int deleteByPrimaryKey(String username);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    List<Administrator> selectByExampleWithRowbounds(AdministratorExample example, RowBounds rowBounds);

    List<Administrator> selectByExample(AdministratorExample example);

    Administrator selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByExample(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);
}