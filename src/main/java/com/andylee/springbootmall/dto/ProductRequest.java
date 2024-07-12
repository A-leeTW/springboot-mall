package com.andylee.springbootmall.dto;

import com.andylee.springbootmall.constant.ProductCategory;

import javax.validation.constraints.NotNull;


public class ProductRequest {

    @NotNull // pom.xml 需加入 validation
    private String productName;

    // 將類型寫成 enum類型可增加程式可讀性
    @NotNull
    private ProductCategory category;

    @NotNull
    private String imageUrl;

    @NotNull
    private Integer price;

    @NotNull
    private Integer stock;

    @NotNull
    private String description;

    // private Integer productId;       id 系統自動生成
    // private Date createdDate;       date 系統自動生成
    // private Date lastModifiedDate;  date 系統自動生成

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
