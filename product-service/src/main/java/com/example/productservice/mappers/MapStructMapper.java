package com.example.productservice.mappers;

import com.example.productservice.dto.ProductResponse;
import com.example.productservice.entities.Product;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
   ProductResponse productToProductResponse(Product product);
   Product productResponseToProduct(ProductResponse productResponse);
}
