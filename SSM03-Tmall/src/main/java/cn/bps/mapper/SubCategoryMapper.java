package cn.bps.mapper;

import cn.bps.pojo.SubCategory;
import cn.bps.pojo.SubCategoryExample;
import java.util.List;

public interface SubCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubCategory record);

    int insertSelective(SubCategory record);

    List<SubCategory> selectByExample(SubCategoryExample example);

    SubCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubCategory record);

    int updateByPrimaryKey(SubCategory record);
}