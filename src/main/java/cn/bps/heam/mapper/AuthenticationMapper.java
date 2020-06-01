package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.Authentication;
import cn.bps.heam.domain.model.AuthenticationExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface AuthenticationMapper {
    long countByExample(AuthenticationExample example);

    int insert(Authentication record);

    int insertSelective(Authentication record);

    List<Authentication> selectByExampleWithRowbounds(AuthenticationExample example, RowBounds rowBounds);

    List<Authentication> selectByExample(AuthenticationExample example);

    Authentication selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Authentication record);

    int updateByPrimaryKey(Authentication record);
}