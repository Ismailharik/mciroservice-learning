package com.example.orderservice.mappers;

import com.example.orderservice.dto.OrderLineItemsDto;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.entities.Order;
import com.example.orderservice.entities.OrderLineItems;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

//   Order orderRequestToOrder(OrderRequest orderRequest);
//   OrderRequest OrderToOrderRequest(Order order);

   OrderLineItems orderLineItemsDtoToOrderLineItems(OrderLineItemsDto orderLineItemsDto);
   OrderLineItemsDto OrderLineItemsToOrderLineItemsDto(OrderLineItems orderLineItems);

}
