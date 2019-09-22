package cn.bps.service;

import cn.bps.mapper.ProductBindFilterMapper;
import cn.bps.pojo.Product;
import cn.bps.pojo.ProductBindFilter;
import cn.bps.pojo.ProductBindFilterExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductBindFilterServiceImp implements ProductBindFilterService {

    @Autowired
    private ProductBindFilterMapper productBindFilterMapper;


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

        Set<Integer> productIdSet = new LinkedHashSet<>();
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

    @Override
    public List<ProductBindFilter> cloneByProductId(Integer oldId, Integer newId) {

        ProductBindFilterExample productBindFilterExample = new ProductBindFilterExample();
        productBindFilterExample.createCriteria().andProduct_idEqualTo(oldId);
        List<ProductBindFilter> productBindFilters = productBindFilterMapper.selectByExample(productBindFilterExample);

        List<ProductBindFilter> newProductBindFilters = new ArrayList<>();
        for(ProductBindFilter productBindFilter : productBindFilters){
            ProductBindFilter newProductBindFilter = new ProductBindFilter();
            newProductBindFilter.setFilter_value_id(productBindFilter.getFilter_value_id());
            newProductBindFilter.setProduct_id(newId);
            newProductBindFilters.add(newProductBindFilter);

        }

        return newProductBindFilters;
    }

    @Override
    public List<Integer> getLabelIdsByProductId(Integer id) {

        ProductBindFilterExample productBindFilterExample = new ProductBindFilterExample();
        productBindFilterExample.createCriteria().andProduct_idEqualTo(id);

        List<ProductBindFilter> productBindFilters = productBindFilterMapper.selectByExample(productBindFilterExample);
        List<Integer> labelIds = new ArrayList<>();

        if(productBindFilters.size()>0){

            for(ProductBindFilter productBindFilter : productBindFilters){
                labelIds.add(productBindFilter.getFilter_value_id());
            }
            return labelIds;
        }

        return labelIds;
    }

    @Override
    public List<Integer> getLabelIdsByProduct(Product product) {
        return getLabelIdsByProductId(product.getId());
    }
}
