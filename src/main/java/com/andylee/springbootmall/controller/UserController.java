package com.andylee.springbootmall.controller;

import com.andylee.springbootmall.dto.UserLoginRequest;
import com.andylee.springbootmall.dto.UserRegisterRequest;
import com.andylee.springbootmall.model.User;
import com.andylee.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // RESTful 中，創建資源對應到 POST方法
    // 資安考量，需要使用 requestbody 傳遞參數
    @PostMapping("/users/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest){

        Integer userId = userService.register(userRegisterRequest);

        User user = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }

    @PostMapping("/users/login")
    public ResponseEntity<User> login(@RequestBody @Valid UserLoginRequest userLoginRequest){

        User user = userService.login(userLoginRequest);

        return ResponseEntity.status(HttpStatus.OK).body(user); // 將成功狀態回傳在body

    }
}
