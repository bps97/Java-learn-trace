package cn.bps.service;

import cn.bps.pojo.CollectionItem;

import java.util.List;
import java.util.Set;

public interface CollectionItemService {

    List<CollectionItem> getAllCollection();

    int removeCollectionItem(int collectionItemId);

    int addCollectionItem(CollectionItem collectionItem);

    Set<Integer> getAllProductIDSet();
}
