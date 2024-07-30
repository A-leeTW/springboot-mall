package com.andylee.springbootmall.service.impl;

import com.andylee.springbootmall.dao.OrderDao;
import com.andylee.springbootmall.dao.ProductDao;
import com.andylee.springbootmall.dto.BuyItem;
import com.andylee.springbootmall.dto.CreateOrderRequest;
import com.andylee.springbootmall.model.OrderItem;
import com.andylee.springbootmall.model.Product;
import com.andylee.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;
        List<OrderItem> orderItemList= new ArrayList<>();

        // for 迴圈計算 buyItem(訂單) 內所有 product 價錢總和

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()){

            Product product = productDao.getProductById(buyItem.getProductId());

            // 計算總價
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        // 創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }
}

