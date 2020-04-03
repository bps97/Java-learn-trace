package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.Address;
import cn.bps.heam.domain.model.AddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(String id);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExampleWithRowbounds(AddressExample example, RowBounds rowBounds);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}