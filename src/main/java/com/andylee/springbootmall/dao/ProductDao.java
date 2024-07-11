package com.andylee.springbootmall.dao;

import com.andylee.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

}
