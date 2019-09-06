package cn.bps.service;

import cn.bps.mapper.ProductBindFilterMapper;
import cn.bps.mapper.ProductMapper;
import cn.bps.pojo.Product;
import cn.bps.pojo.ProductBindFilter;
import cn.bps.pojo.ProductExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductMapper productMapper;


    @Override
    public List<Product> getProductList(int start, int step) {
        ProductExample productExample = new ProductExample();
        RowBounds rowBounds = new RowBounds(start-1,step);
        return productMapper.selectByExampleWithRowbounds(productExample,rowBounds);

    }

    @Override
    public List<Product> getProductListByProductIdSet(Set<Integer> set) {
        ProductExample productExample = new ProductExample();

        if (set.size() > 0) {
            productExample.createCriteria().andIdIn(new ArrayList(set));
            return productMapper.selectByExample(productExample);

        }
        return new ArrayList<>();
    }

    @Override
    public List<Product> rowBoundsProduct(Set<Integer> set, Integer start, Integer step) {
        ProductExample productExample = new ProductExample();
        RowBounds rowBounds = new RowBounds(start,step);

        if (set.size() > 0) {
            productExample.createCriteria().andIdIn(new ArrayList(set));
            return productMapper.selectByExampleWithRowbounds(productExample,rowBounds);

        }
        return new ArrayList<>();
    }

    @Override
    public Product getProductById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteOneById(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertOne(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public int updateOne(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }


}
