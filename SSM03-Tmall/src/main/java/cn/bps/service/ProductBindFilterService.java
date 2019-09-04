package cn.bps.service;

import cn.bps.pojo.Product;

import java.util.List;
import java.util.Set;

public interface ProductBindFilterService {
    Set<Integer> getProductIdSet(Set<Integer> filterIdSet);
    Set<Integer> getProductIdSetByFilterId(Integer filterId);
    Set<Integer> getProductIdSet();

}
