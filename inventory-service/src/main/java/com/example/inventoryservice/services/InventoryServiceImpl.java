package com.example.inventoryservice.services;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        log.info("Checking Inventory");

         return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                 .map(inventory -> InventoryResponse.builder()
                         .isInStock(inventory.getQuantity()>0)
                         .skuCode(inventory.getSkuCode())
                         .build()
         ).toList();

    }
}
