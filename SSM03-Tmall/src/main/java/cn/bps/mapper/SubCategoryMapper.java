package cn.bps.mapper;

import cn.bps.pojo.SubCategory;
import cn.bps.pojo.SubCategoryExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface SubCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubCategory record);

    int insertSelective(SubCategory record);

    List<SubCategory> selectByExampleWithRowbounds(SubCategoryExample example, RowBounds rowBounds);

    List<SubCategory> selectByExample(SubCategoryExample example);

    SubCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubCategory record);

    int updateByPrimaryKey(SubCategory record);
}