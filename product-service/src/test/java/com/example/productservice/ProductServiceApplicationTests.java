package com.example.productservice;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.repositories.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
@SpringBootTest
//@Testcontainers
//@AutoConfigureMockMvc
class ProductServiceApplicationTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
////    @Container
////    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @DynamicPropertySource
//    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
////        dynamicPropertyRegistry.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
//
//    }
//    @Test
//    void shouldCreateProduct() throws Exception {
//        ProductRequest productRequest = getProductRequest();
//        String productRequestString = objectMapper.writeValueAsString(productRequest);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(productRequestString))//can accept only
//                .andExpect(status().isCreated());
//     //   Assertions.assertEquals(2,productRepository.findAll().size());
//
//    }
//
//    private ProductRequest getProductRequest() {
//        return ProductRequest.builder()
//                .name("telephone")
//                .description("iphone test")
//                .price(BigDecimal.valueOf(2090))
//                .build();
//    }
//
}
