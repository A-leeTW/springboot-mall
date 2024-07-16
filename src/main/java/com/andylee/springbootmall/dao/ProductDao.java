package com.andylee.springbootmall.dao;

import com.andylee.springbootmall.constant.ProductCategory;
import com.andylee.springbootmall.dto.ProductQueryParams;
import com.andylee.springbootmall.dto.ProductRequest;
import com.andylee.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
