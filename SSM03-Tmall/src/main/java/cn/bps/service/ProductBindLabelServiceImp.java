package cn.bps.service;

import cn.bps.mapper.ProductBindLabelMapper;
import cn.bps.pojo.Product;
import cn.bps.pojo.ProductBindLabel;
import cn.bps.pojo.ProductBindLabelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductBindLabelServiceImp implements ProductBindLabelService {

    @Autowired
    private ProductBindLabelMapper productBindLabelMapper;


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
    public Set<Integer> getProductIdSetByFilterId(Integer labelId){

        ProductBindLabelExample productBindLabelExample = new ProductBindLabelExample();
        productBindLabelExample.createCriteria().andLabel_idEqualTo(labelId);
        List<ProductBindLabel> productBindLabel = productBindLabelMapper.selectByExample(productBindLabelExample);

        Set<Integer> productIdSet = new LinkedHashSet<>();
        for(ProductBindLabel pbf:productBindLabel){
            productIdSet.add(pbf.getProduct_id());
        }
        return productIdSet;

    }

    @Override
    public Set<Integer> getAllProductIdSet() {
        ProductBindLabelExample productBindLabelExample = new ProductBindLabelExample();
        List<ProductBindLabel> productBindLabel = productBindLabelMapper.selectByExample(productBindLabelExample);
        Set<Integer> productIdSet = new HashSet();
        for(ProductBindLabel pbf:productBindLabel){
            productIdSet.add(pbf.getProduct_id());
        }
        return productIdSet;
    }

    @Override
    public void insertProductBindLabel(List<ProductBindLabel> productBindLabels) {
        for(ProductBindLabel productBindLabel : productBindLabels){
            productBindLabelMapper.insertSelective(productBindLabel);
        }
        return ;
    }

    @Override
    public int deleteDemos(int productId) {

        ProductBindLabelExample productBindLabelExample = new ProductBindLabelExample();
        productBindLabelExample.createCriteria().andProduct_idEqualTo(productId);
        return productBindLabelMapper.deleteByExample(productBindLabelExample);
    }

    @Override
    public List<ProductBindLabel> cloneByProductId(Integer oldId, Integer newId) {

        ProductBindLabelExample productBindLabelExample = new ProductBindLabelExample();
        productBindLabelExample.createCriteria().andProduct_idEqualTo(oldId);
        List<ProductBindLabel> productBindLabels = productBindLabelMapper.selectByExample(productBindLabelExample);

        List<ProductBindLabel> newProductBindLabels = new ArrayList<>();
        for(ProductBindLabel productBindLabel : productBindLabels){
            ProductBindLabel newProductBindLabel = new ProductBindLabel();
            newProductBindLabel.setLabel_id(productBindLabel.getLabel_id());
            newProductBindLabel.setProduct_id(newId);
            newProductBindLabels.add(newProductBindLabel);

        }

        return newProductBindLabels;
    }

    @Override
    public List<Integer> getLabelIdsByProductId(Integer id) {

        ProductBindLabelExample productBindLabelExample = new ProductBindLabelExample();
        productBindLabelExample.createCriteria().andProduct_idEqualTo(id);

        List<ProductBindLabel> productBindLabels = productBindLabelMapper.selectByExample(productBindLabelExample);
        List<Integer> labelIds = new ArrayList<>();

        if(productBindLabels.size()>0){

            for(ProductBindLabel productBindLabel : productBindLabels){
                labelIds.add(productBindLabel.getLabel_id());
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
