package com.andylee.springbootmall.dao.impl;

import com.andylee.springbootmall.dao.ProductDao;
import com.andylee.springbootmall.model.Product;
import com.andylee.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {

        String sql ="select product_id,product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date " +
                "from product where product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);


        // 在 query處，右鍵萬用鍵
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        // 如果資料不為空，則顯示第一筆
        if (productList.size() > 0){
            return productList.get(0);
        }else {
            return null;
        }

    }
}
