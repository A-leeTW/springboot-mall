package com.andylee.springbootmall.controller;

import com.andylee.springbootmall.constant.ProductCategory;
import com.andylee.springbootmall.dto.ProductQueryParams;
import com.andylee.springbootmall.dto.ProductRequest;
import com.andylee.springbootmall.model.Product;
import com.andylee.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products") // 查詢必須是複數  // reuqire = false 使參數可以為 null
    public ResponseEntity<List<Product>> getProducts(
            // 查詢條件的　filterling
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,

            // 排序 Sorting
            @RequestParam(defaultValue = "created_date") String orderBy,  // 預設 created_date 排序
            @RequestParam(defaultValue = "desc") String sort              //  desc sql中的降序
            ){
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);

        List<Product> productList = productService.getProducts(productQueryParams);

        return ResponseEntity.status(HttpStatus.OK).body(productList);

    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){

        Product product = productService.getProductById(productId);

        if (product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")                    // 有使用NotNull註解，須加上 @Valid 在參數前
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){

        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }

    @PutMapping("/products/{productId}")        // 有使用NotNull註解，須加上 @Valid 在參數前
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest){

        // 檢查 product 是否存在
        Product product = productService.getProductById(productId);

        if (product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 兩個參數，表示修改哪一個ID 以及要修改的值
        productService.updateProduct(productId, productRequest);

        Product updateProduct = productService.getProductById(productId);

        // HttpStatus.OK  表示更新成功狀態碼  .body 則表示回傳數據在 body
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){

        productService.deleteProductById(productId);

        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
