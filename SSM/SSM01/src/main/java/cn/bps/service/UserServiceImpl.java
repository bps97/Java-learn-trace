package cn.bps.service;

import cn.bps.dao.UserDAO;
import cn.bps.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    public User findUserById(int id) {
        return userDAO.findUserById(id);
    }
}
