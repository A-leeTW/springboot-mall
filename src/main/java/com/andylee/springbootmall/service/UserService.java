package com.andylee.springbootmall.service;

import com.andylee.springbootmall.dto.UserLoginRequest;
import com.andylee.springbootmall.dto.UserRegisterRequest;
import com.andylee.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
