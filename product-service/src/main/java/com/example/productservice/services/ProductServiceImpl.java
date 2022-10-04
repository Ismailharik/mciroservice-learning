package com.example.productservice.services;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.entities.Product;
import com.example.productservice.mappers.MapStructMapper;

import com.example.productservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private  final ProductRepository productRepository;
    private  final MapStructMapper mapStructMapper;
    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        product = productRepository.save(product);
        log.info("Product with id {} is saved ",product.getId());

    }

    @Override
    public List<ProductResponse> getAllProducts() {
         List<ProductResponse> productResponses= productRepository.findAll().stream().
//                 map(product -> mapStructMapper.productToProductResponse(product)).collect(Collectors.toList());
        map(mapStructMapper::productToProductResponse).collect(Collectors.toList());

        return productResponses;
    }
}
