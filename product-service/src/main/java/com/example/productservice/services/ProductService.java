package com.example.productservice.services;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
