package cn.bps.service;

import cn.bps.mapper.ProductItemMapper;
import cn.bps.pojo.Product;
import cn.bps.pojo.ProductItem;
import cn.bps.pojo.ProductItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShoppingCartServiceImp implements ShoppingCartService {
    @Autowired
    private ProductItemMapper productItemMapper;

    @Autowired
    private ProductService productService;

    @Override
    public List<ProductItem> getShoppingCartProductByUserId(int userId) {

        ProductItemExample shoppingCartExample = new ProductItemExample();
        shoppingCartExample.setOrderByClause("user_id");
        shoppingCartExample.createCriteria().andUser_idEqualTo(userId);

        return productItemMapper.selectByExample(shoppingCartExample);
    }



    @Override
    public float countTotalPrice(int userId) {

        List<ProductItem> productItems = getShoppingCartProductByUserId(userId);
        int count = 0;

        for(ProductItem shoppingCart : productItems){
            count += shoppingCart.getQuality() * productService.getProductById(shoppingCart.getProduct_id()).getPrice();
        }


        return count;
    }

    @Override
    public float countTotalPrice(List<Integer> shoppingCartIDs) {
        int count=0;
        for(Integer id:shoppingCartIDs){
            ProductItem item = productItemMapper.selectByPrimaryKey(id);
            Integer productId = item.getProduct_id();
            Product product = productService.getProductById(productId);
            count += product.getPrice()*item.getQuality();
        }
        return count;
    }

    @Override
    public int removeOne(int shopId) {
        return productItemMapper.deleteByPrimaryKey(shopId);

    }


    @Override
    public int insertOne(ProductItem productItem) {

        ProductItemExample shoppingCartExample = new ProductItemExample();
        shoppingCartExample.createCriteria().andUser_idEqualTo(productItem.getUser_id());
        long count = productItemMapper.countByExample(shoppingCartExample);
        if(count >= 10){
            return  -1;
        }


        return productItemMapper.insert(productItem);
    }

    @Override
    public int insertOne(int productId, int userId, int quality) {

//        if(isProductExist(productId)){
//
//        }

        ProductItem shoppingCart = new ProductItem();
        shoppingCart.setProduct_id(productId);
        shoppingCart.setQuality(quality);
        shoppingCart.setUser_id(userId);
        return insertOne(shoppingCart);
    }

    @Override
    public List<ProductItem> getShoppingCartByIds(List<Integer> itemIds) {

        ProductItemExample shoppingCartExample = new ProductItemExample();
        shoppingCartExample.createCriteria().andIdIn(itemIds);
        return productItemMapper.selectByExample(shoppingCartExample);
    }

    //通过id去修改数量
    @Override
    public Integer updateItemQualityByItemId(int itemId, int quality) {

        ProductItemExample shoppingCartExample = new ProductItemExample();
        shoppingCartExample.createCriteria().andIdEqualTo(itemId);
        ProductItem item = productItemMapper.selectByExample(shoppingCartExample).get(0);
        item.setQuality(quality);

        return productItemMapper.updateByPrimaryKey(item);
    }


}
