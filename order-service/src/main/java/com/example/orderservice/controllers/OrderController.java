package com.example.orderservice.controllers;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String orderPlace(@RequestBody OrderRequest orderRequest){
        System.out.println(orderRequest);
        orderService.placeOrder(orderRequest);
        return "Order Place Successfully";
    }

}
