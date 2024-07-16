package com.andylee.springbootmall.dto;

import com.andylee.springbootmall.constant.ProductCategory;


// 將參數放在這個 class 裡，可以省下大量修改時間，增加效率
public class ProductQueryParams {
    ProductCategory category;
    String search;
    String orderBy;
    String sort;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
