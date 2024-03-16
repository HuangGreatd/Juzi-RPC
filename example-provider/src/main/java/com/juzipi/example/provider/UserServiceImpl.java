package com.juzipi.example.provider;

import com.juzipi.common.model.User;
import com.juzipi.common.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
