package com.andylee.springbootmall.service;

import com.andylee.springbootmall.dto.CreateOrderRequest;
import com.andylee.springbootmall.model.Order;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
