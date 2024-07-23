package com.andylee.springbootmall.service.impl;

import com.andylee.springbootmall.dao.UserDao;
import com.andylee.springbootmall.dto.UserLoginRequest;
import com.andylee.springbootmall.dto.UserRegisterRequest;
import com.andylee.springbootmall.model.User;
import com.andylee.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    // import slf4j
    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    // register 表示註冊帳號相關的方法，內部才會再細分
    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {

        // 檢查註冊的 Email
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if (user != null){
            // {} 表示後方參數的值，且位置對應後方參數位置
            log.warn("該 email {} 已被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 創建帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {

        User user = userDao.getUserByEmail(userLoginRequest.getEmail());

        if (user == null){
            log.warn("該 email {} 尚未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (user.getPassword().equals(userLoginRequest.getPassword())){
            return user;
        }else {
            log.warn("email {} 的密碼不正確", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
}
