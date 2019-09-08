package cn.bps.service;

import cn.bps.mapper.ShoppingCartMapper;
import cn.bps.pojo.ShoppingCart;
import cn.bps.pojo.ShoppingCartExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShoppingCartServiceImp implements ShoppingCartService {
    @Autowired
    ShoppingCartMapper shoppingCartMapper;

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
}
