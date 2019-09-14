package cn.bps.mapper;

import cn.bps.pojo.Address;
import cn.bps.pojo.AddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExampleWithRowbounds(AddressExample example, RowBounds rowBounds);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}