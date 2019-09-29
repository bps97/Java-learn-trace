package cn.bps.service;

import cn.bps.mapper.CollectionItemMapper;
import cn.bps.pojo.CollectionItem;
import cn.bps.pojo.CollectionItemExample;
import cn.bps.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CollectionItemServiceImp implements CollectionItemService {

    @Autowired
    private CollectionItemMapper collectionItemMapper;
    @Autowired
    private ProductService productService;


    @Override
    public List<CollectionItem> getAllCollection() {

        CollectionItemExample collectionItemExample = new CollectionItemExample();
        List<CollectionItem> collectionItems = collectionItemMapper.selectByExample(collectionItemExample);

        if(collectionItems.size()>0) return collectionItems;
        return null;
    }

    @Override
    public int removeCollectionItem(int collectionItemId) {
        return collectionItemMapper.deleteByPrimaryKey(collectionItemId);
    }

    @Override
    public int addCollectionItem(CollectionItem collectionItem) {
        CollectionItemExample collectionItemExample = new CollectionItemExample();
        collectionItemExample.createCriteria().andProduct_idEqualTo(collectionItem.getProduct_id());
        List<CollectionItem> collectionItems = collectionItemMapper.selectByExample(collectionItemExample);
        if(collectionItems.size()>0) {
            return 0;
        }
        return collectionItemMapper.insert(collectionItem);
    }

    @Override
    public Set<Integer> getAllProductIDSet() {
        List<CollectionItem> collectionItems = getAllCollection();
        if(collectionItems!=null){
            Set<Integer> productIdSet = collectionItems.stream().map(CollectionItem::getProduct_id).collect(Collectors.toSet());
            if (productIdSet.size()>0) return productIdSet;
        }
        return null;
    }

    @Override
    public Map<CollectionItem, Product> getProductMap() {
        List<CollectionItem> collectionItems = getAllCollection();
        Map<CollectionItem, Product> map = new HashMap<>();
        if(collectionItems!=null) {
            for (CollectionItem collectionItem : collectionItems) {
                map.put(collectionItem, productService.getProductById(collectionItem.getProduct_id()));
            }
        }
        return map;
    }
}
