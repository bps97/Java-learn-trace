package cn.bps.mapper;

import cn.bps.pojo.CategoryLogo;
import cn.bps.pojo.CategoryLogoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CategoryLogoMapper {
    long countByExample(CategoryLogoExample example);

    int deleteByExample(CategoryLogoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryLogo record);

    int insertSelective(CategoryLogo record);

    List<CategoryLogo> selectByExampleWithRowbounds(CategoryLogoExample example, RowBounds rowBounds);

    List<CategoryLogo> selectByExample(CategoryLogoExample example);

    CategoryLogo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CategoryLogo record, @Param("example") CategoryLogoExample example);

    int updateByExample(@Param("record") CategoryLogo record, @Param("example") CategoryLogoExample example);

    int updateByPrimaryKeySelective(CategoryLogo record);

    int updateByPrimaryKey(CategoryLogo record);
}