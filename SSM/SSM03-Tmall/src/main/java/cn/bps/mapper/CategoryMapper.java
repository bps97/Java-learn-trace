package cn.bps.mapper;

import cn.bps.pojo.Category;
import cn.bps.pojo.CategoryExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExampleWithRowbounds(CategoryExample example, RowBounds rowBounds);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}