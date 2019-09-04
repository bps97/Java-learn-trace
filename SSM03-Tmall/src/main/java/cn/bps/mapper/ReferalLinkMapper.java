package cn.bps.mapper;

import cn.bps.pojo.ReferalLink;
import cn.bps.pojo.ReferalLinkExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ReferalLinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReferalLink record);

    int insertSelective(ReferalLink record);

    List<ReferalLink> selectByExampleWithRowbounds(ReferalLinkExample example, RowBounds rowBounds);

    List<ReferalLink> selectByExample(ReferalLinkExample example);

    ReferalLink selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReferalLink record);

    int updateByPrimaryKey(ReferalLink record);
}