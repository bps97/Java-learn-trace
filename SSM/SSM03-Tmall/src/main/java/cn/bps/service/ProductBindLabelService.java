package cn.bps.service;

import cn.bps.pojo.Product;
import cn.bps.pojo.ProductBindLabel;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ProductBindLabelService {

    int addProductBindLabel(List<ProductBindLabel> productBindLabels);

    int deleteProductBindLabel(int productId);

    Set<Integer> getProductIdSet(Collection<Integer> filterIdSet);

    Set<Integer> getProductIdSet(Integer filterId);

    Set<Integer> getAllProductIdSet();

    List<ProductBindLabel> cloneByProductId(Integer oldId, Integer newId);

    List<Integer> getLabelIdsByProductId(Integer id);

    List<Integer> getLabelIdsByProduct(Product product);
}
