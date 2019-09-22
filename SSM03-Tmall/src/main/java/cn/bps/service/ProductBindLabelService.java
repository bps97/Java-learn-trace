package cn.bps.service;

import cn.bps.pojo.Product;
import cn.bps.pojo.ProductBindLabel;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ProductBindLabelService {
    Set<Integer> getProductIdSet(Collection<Integer> filterIdSet);
    Set<Integer> getProductIdSetByFilterId(Integer filterId);
    Set<Integer> getAllProductIdSet();
    void insertProductBindLabel(List<ProductBindLabel> productBindLabels);
    int deleteDemos(int productId);

    List<ProductBindLabel> cloneByProductId(Integer oldId, Integer newId);

    List<Integer> getLabelIdsByProductId(Integer id);
    List<Integer> getLabelIdsByProduct(Product product);
}
