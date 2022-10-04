package com.example.orderservice.services;

import com.example.orderservice.dto.InventoryResponse;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.entities.Order;
import com.example.orderservice.entities.OrderLineItems;
import com.example.orderservice.mappers.MapStructMapper;
import com.example.orderservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MapStructMapper mapStructMapper;
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    public void placeOrder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtos().stream()
                .map(mapStructMapper::orderLineItemsDtoToOrderLineItems).toList();
        order.setOrderLineItems(orderLineItems);

        List<String> skuCodes = order.getOrderLineItems().stream().map(OrderLineItems::getSkuCode).toList();
        System.out.println("SKU CODES"+skuCodes);
        //Call inventory service and place order if product they are
        // in stock
        InventoryResponse[] inventoryResponses= webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",uriBuilder ->
                        uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class) //By default it will make an async request
                .block();
        System.out.println("inventoryResponses");
        System.out.println(inventoryResponses);
        boolean allProductInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);

        if(allProductInStock){
            orderRepository.save(order);
        } else{
            throw new IllegalArgumentException("Product is not in the stock  , please try again later");
        }

    }


}
