package cn.bps.service;

import cn.bps.pojo.CollectionItem;
import cn.bps.pojo.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CollectionItemService {

    List<CollectionItem> getAllCollection();

    int removeCollectionItem(int collectionItemId);

    int addCollectionItem(CollectionItem collectionItem);

    Set<Integer> getAllProductIDSet();

    Map<CollectionItem, Product> getProductMap();
}
