package cn.bps.service;

import cn.bps.mapper.CollectionItemMapper;
import cn.bps.pojo.CollectionItem;
import cn.bps.pojo.CollectionItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CollectionItemServiceImp implements CollectionItemService {

    @Autowired
    CollectionItemMapper collectionItemMapper;


    @Override
    public List<CollectionItem> getAllCollection() {

        CollectionItemExample collectionItemExample = new CollectionItemExample();
        List<CollectionItem> collectionItems = collectionItemMapper.selectByExample(collectionItemExample);

        if(collectionItems.size()>0) return collectionItems;
        return null;
    }

    @Override
    public int removeCollectionItem(int collectionItemId) {
        return 0;
    }

    @Override
    public int addCollectionItem(CollectionItem collectionItem) {
        return collectionItemMapper.insert(collectionItem);
    }

    @Override
    public Set<Integer> getAllProductIDSet() {
        List<CollectionItem> collectionItems = getAllCollection();
        Set<Integer> productIdSet = collectionItems.stream().map(CollectionItem::getProduct_id).collect(Collectors.toSet());
        if (productIdSet.size()>0) return productIdSet;
        return null;
    }
}
