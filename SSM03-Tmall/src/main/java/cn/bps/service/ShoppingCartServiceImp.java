package cn.bps.service;

import cn.bps.mapper.ShoppingCartMapper;
import cn.bps.pojo.ShoppingCart;
import cn.bps.pojo.ShoppingCartExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShoppingCartServiceImp implements ShoppingCartService {
    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Autowired
    ProductService productService;

    @Override
    public List<ShoppingCart> getShoppingCartProductByUserId(int userId) {

        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.setOrderByClause("user_id");
        shoppingCartExample.createCriteria().andUser_idEqualTo(userId);

        return shoppingCartMapper.selectByExample(shoppingCartExample);
    }

    @Override
    public int insertOne(ShoppingCart shoppingCart) {

        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.createCriteria().andUser_idEqualTo(shoppingCart.getUser_id());
        long count = shoppingCartMapper.countByExample(shoppingCartExample);
        if(count >= 10){
            return  -1;
        }


        return shoppingCartMapper.insert(shoppingCart);
    }

    @Override
    public float countTotalPrice(int userId) {

        List<ShoppingCart> shoppingCarts = getShoppingCartProductByUserId(userId);
        int count = 0;

        for(ShoppingCart shoppingCart : shoppingCarts){
            count += shoppingCart.getQuality() * productService.getProductById(shoppingCart.getProduct_id()).getPrice();
        }


        return count;
    }

    @Override
    public float countTotalPrice(List<Integer> shoppingCartIDs) {
        int count=0;
        for(Integer id:shoppingCartIDs){
            Integer productId = shoppingCartMapper.selectByPrimaryKey(id).getProduct_id();
            count += productService.getProductById(productId).getPrice();
        }
        return count;
    }

    @Override
    public int removeOne(int shopId) {

        return shoppingCartMapper.deleteByPrimaryKey(shopId);

    }
}
