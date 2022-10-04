package com.example.orderservice.services;

import com.example.orderservice.dto.OrderRequest;

public interface OrderService  {
    void placeOrder(OrderRequest orderRequest);
}
