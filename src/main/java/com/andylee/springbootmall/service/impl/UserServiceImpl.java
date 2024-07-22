package com.andylee.springbootmall.service.impl;

import com.andylee.springbootmall.dao.UserDao;
import com.andylee.springbootmall.dto.UserRegisterRequest;
import com.andylee.springbootmall.model.User;
import com.andylee.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
