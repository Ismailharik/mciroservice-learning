package com.example.orderservice.dto;

import com.example.orderservice.entities.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {
    private String orderNumber;
    private List<OrderLineItemsDto> orderLineItemsDtos;
}
