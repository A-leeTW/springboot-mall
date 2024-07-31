package com.andylee.springbootmall.service;

import com.andylee.springbootmall.dto.CreateOrderRequest;
import com.andylee.springbootmall.dto.OrderQueryParams;
import com.andylee.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
