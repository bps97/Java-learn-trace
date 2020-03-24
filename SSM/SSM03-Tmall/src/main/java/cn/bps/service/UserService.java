package cn.bps.service;

import cn.bps.pojo.User;

public interface UserService {
    User getUserByPhone(String phone);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    int InsertOne(User user);
    User getUserById(int id);

    void updateInfo(User user);
}
