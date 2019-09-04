package cn.bps.service;

import cn.bps.mapper.ProductBindFilterMapper;
import cn.bps.mapper.ProductMapper;
import cn.bps.pojo.Product;
import cn.bps.pojo.ProductBindFilter;
import cn.bps.pojo.ProductExample;
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
        productExample.createCriteria().andIdBetween(start,step+start);
        return productMapper.selectByExample(productExample);

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


}
