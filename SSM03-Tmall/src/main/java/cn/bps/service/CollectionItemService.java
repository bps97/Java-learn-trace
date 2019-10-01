package cn.bps.service;

import cn.bps.pojo.CollectionItem;
import cn.bps.pojo.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CollectionItemService {

    int removeCollectionItem(int collectionItemId);

    int removeCollectionItem(CollectionItem collectionItem);

    int addCollectionItem(CollectionItem collectionItem);

    List<CollectionItem> getAllCollection();

    Set<Integer> getAllProductIDSet();

    Map<CollectionItem, Product> getProductMap();
}
