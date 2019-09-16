package cn.bps.service;

import cn.bps.mapper.ProductMapper;
import cn.bps.pojo.Product;
import cn.bps.pojo.ProductExample;
import cn.bps.pojo.ProductItem;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> getProductList(int start, int step) {
        ProductExample productExample = new ProductExample();
        RowBounds rowBounds = new RowBounds(start-1,step);
        return productMapper.selectByExampleWithRowbounds(productExample,rowBounds);

    }

    @Override
    public List<Product> getProductListByProductIdSet(Set<Integer> set) {
        ProductExample productExample = new ProductExample();

        if (set.size() > 0) {
            productExample.createCriteria().andIdIn(new ArrayList(set));
            return productMapper.selectByExample(productExample);

        }
        return new ArrayList<>();
    }

    @Override
    public List<Product> rowBoundsProduct(Set<Integer> set, Integer start, Integer step) {
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andUndercarriageEqualTo(0);
        RowBounds rowBounds = new RowBounds(start,step);

        if (set.size() > 0) {
            productExample.createCriteria().andIdIn(new ArrayList(set));
            return productMapper.selectByExampleWithRowbounds(productExample,rowBounds);

        }
        return new ArrayList<>();
    }

    @Override
    public Product getProductById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteOneById(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertOne(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public int updateOne(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }

    @Override
    public Set<Integer> getProductIDSetByProductName(String name) {

        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andNameLike("%"+name+"%");
        List<Product> products = productMapper.selectByExample(productExample);
        Set<Integer> productIdSet = new HashSet<>();
        for(Product product: products){
            productIdSet.add(product.getId());
        }

        return productIdSet;
    }

    @Override
    public Map<Integer, Product> getProductMapByShoppingCartList(List<ProductItem> shoppingCarts) {

        Map<Integer, Product> map = new HashMap<>();

        for(ProductItem shoppingCart : shoppingCarts){
            map.put(shoppingCart.getProduct_id(),productMapper.selectByPrimaryKey(shoppingCart.getProduct_id()));
        }

        return map;
    }


}
