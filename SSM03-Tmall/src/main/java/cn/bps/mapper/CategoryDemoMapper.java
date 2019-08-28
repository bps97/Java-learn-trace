package cn.bps.mapper;

import cn.bps.pojo.CategoryDemo;
import cn.bps.pojo.CategoryDemoExample;

public interface CategoryDemoMapper {
    long countByExample(CategoryDemoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryDemo record);

    int insertSelective(CategoryDemo record);

    CategoryDemo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryDemo record);

    int updateByPrimaryKey(CategoryDemo record);
}