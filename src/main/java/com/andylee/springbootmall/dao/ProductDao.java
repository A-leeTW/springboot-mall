package com.andylee.springbootmall.dao;

import com.andylee.springbootmall.dto.ProductRequest;
import com.andylee.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

}
