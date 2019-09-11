package cn.bps.service;

import cn.bps.mapper.ProductBindFilterMapper;
import cn.bps.pojo.ProductBindFilter;
import cn.bps.pojo.ProductBindFilterExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductBindFilterServiceImp implements ProductBindFilterService {

    @Autowired
    ProductBindFilterMapper productBindFilterMapper;


    public Set<Integer> getProductIdSet(Collection<Integer> filterIdSet) {

        Set<Integer> productIdSet = null;
        if(!filterIdSet.isEmpty()){
            productIdSet = getProductIdSetByFilterId(filterIdSet.iterator().next());
            for(Integer i : filterIdSet){
                productIdSet.retainAll(getProductIdSetByFilterId(i));

            }
            return productIdSet;
        }

        return null;
    }

    @Override
    public Set<Integer> getProductIdSetByFilterId(Integer filterId){

        ProductBindFilterExample productBindFilterExample = new ProductBindFilterExample();
        productBindFilterExample.createCriteria().andFilter_value_idEqualTo(filterId);
        List<ProductBindFilter> productBindFilter = productBindFilterMapper.selectByExample(productBindFilterExample);

        Set<Integer> productIdSet = new HashSet();
        for(ProductBindFilter pbf:productBindFilter){
            productIdSet.add(pbf.getProduct_id());
        }
        return productIdSet;

    }

    @Override
    public Set<Integer> getAllProductIdSet() {
        ProductBindFilterExample productBindFilterExample = new ProductBindFilterExample();
        List<ProductBindFilter> productBindFilter = productBindFilterMapper.selectByExample(productBindFilterExample);
        Set<Integer> productIdSet = new HashSet();
        for(ProductBindFilter pbf:productBindFilter){
            productIdSet.add(pbf.getProduct_id());
        }
        return productIdSet;
    }

    @Override
    public void insertProductBindFilter(List<ProductBindFilter> productBindFilters) {
        for(ProductBindFilter productBindFilter : productBindFilters){
            productBindFilterMapper.insertSelective(productBindFilter);
        }
        return ;
    }

    @Override
    public int deleteDemos(int productId) {

        ProductBindFilterExample productBindFilterExample = new ProductBindFilterExample();
        productBindFilterExample.createCriteria().andProduct_idEqualTo(productId);
        return productBindFilterMapper.deleteByExample(productBindFilterExample);
    }
}
