package cn.bps.mapper;

import cn.bps.pojo.CategoryDemo;
import cn.bps.pojo.CategoryDemoExample;
import java.util.List;

public interface CategoryDemoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryDemo record);

    int insertSelective(CategoryDemo record);

    List<CategoryDemo> selectByExample(CategoryDemoExample example);

    CategoryDemo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryDemo record);

    int updateByPrimaryKey(CategoryDemo record);
}