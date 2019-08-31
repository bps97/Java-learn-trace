package cn.bps.service;

import cn.bps.mapper.UserMapper;
import cn.bps.pojo.User;
import cn.bps.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{


    @Autowired
    private UserMapper userMapper;







    @Override
    public User getUserByPhone(String phone) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneEqualTo(phone);
        User user = (userMapper.selectByExample(userExample).isEmpty())?null:userMapper.selectByExample(userExample).get(0);

        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(username);
        User user = (userMapper.selectByExample(userExample).isEmpty())?null:userMapper.selectByExample(userExample).get(0);

        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(email);
        User user = (userMapper.selectByExample(userExample).isEmpty())?null:userMapper.selectByExample(userExample).get(0);

        return user;
    }

    @Override
    public int InsertOne(User user) {

        return userMapper.insert(user);
    }

    @Override
    public User getUserById(int id) {

        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateInfo(User user) {
        userMapper.updateByPrimaryKey(user);
        return;
    }
}
