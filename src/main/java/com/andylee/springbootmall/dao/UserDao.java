package com.andylee.springbootmall.dao;

import com.andylee.springbootmall.dto.UserRegisterRequest;
import com.andylee.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}