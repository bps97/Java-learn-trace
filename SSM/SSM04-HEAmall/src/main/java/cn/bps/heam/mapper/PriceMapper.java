package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.Price;
import cn.bps.heam.domain.model.template.PriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PriceMapper {
    long countByExample(PriceExample example);

    int deleteByExample(PriceExample example);

    int deleteByPrimaryKey(String id);

    int insert(Price record);

    int insertSelective(Price record);

    List<Price> selectByExampleWithRowbounds(PriceExample example, RowBounds rowBounds);

    List<Price> selectByExample(PriceExample example);

    default Price selectOneByExample(PriceExample example) {
        List<Price> prices = selectByExample(example);
        return !prices.isEmpty() ? prices.get(0) : null;
    }

    Price selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Price record, @Param("example") PriceExample example);

    int updateByExample(@Param("record") Price record, @Param("example") PriceExample example);

    int updateByPrimaryKeySelective(Price record);

    int updateByPrimaryKey(Price record);
}
