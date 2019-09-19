package cn.bps.mapper;

import cn.bps.pojo.ProductImage;
import cn.bps.pojo.ProductImageExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface ProductImageMapper {
    int deleteByExample(ProductImageExample example);

    int insert(ProductImage record);

    int insertSelective(ProductImage record);

    List<ProductImage> selectByExampleWithRowbounds(ProductImageExample example, RowBounds rowBounds);

    List<ProductImage> selectByExample(ProductImageExample example);

    ProductImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductImage record);

    int updateByPrimaryKey(ProductImage record);
}