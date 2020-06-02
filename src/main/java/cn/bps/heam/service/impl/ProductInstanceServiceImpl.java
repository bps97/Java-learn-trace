package cn.bps.heam.service.impl;

import cn.bps.common.lang.api.Filter;
import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.api.Sort;
import cn.bps.common.lang.util.Generator;
import cn.bps.heam.dict.Column;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.*;
import cn.bps.heam.domain.model.template.ProductInstanceExample;
import cn.bps.heam.domain.result.HomeProductResult;
import cn.bps.heam.domain.result.ProductResult;
import cn.bps.heam.mapper.ProductInstanceMapper;
import cn.bps.heam.mapper.ProductMapper;
import cn.bps.heam.service.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.ibatis.session.RowBounds;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ProductInstanceServiceImpl implements ProductInstanceService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductInstanceMapper productInstanceMapper;



/**********************************************************************/


    @Override
    public List<Product> listProducts(List<String> productIds) {
        return null;
    }

    @Override
    public int saveProduct(Product product) {
        int result;
        try{
            result = productMapper.insert(product);
        }catch (org.springframework.dao.DuplicateKeyException e){ // 如果key重复
            String newUUID;
            List<String> uuidList = listProducts().stream().map(Product::getId).collect(Collectors.toList());
            do {
                newUUID = Generator.getUUID();
            }while (uuidList.contains(newUUID));
            product.setId(newUUID);
            result = productMapper.insert(product);
        }
        return result;
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public long countProduct(ProductInstanceExample example) {
        return productInstanceMapper.countByExample(example);
    }

    @Override
    public List<ProductInstance> listProductInstances(ProductInstanceExample example, RowBounds rowBounds) {
        return productInstanceMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public List<ProductInstance> listProductInstances(ProductInstanceExample example) {
        return productInstanceMapper.selectByExample(example);
    }


    @Override
    public List<Product> listProducts() {
        return productMapper.selectByExample(new ProductExample());
    }







}

