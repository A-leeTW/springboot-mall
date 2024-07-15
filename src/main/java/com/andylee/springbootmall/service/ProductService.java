package com.andylee.springbootmall.service;

import com.andylee.springbootmall.dto.ProductRequest;
import com.andylee.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
