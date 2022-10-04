package com.example.inventoryservice.controllers;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    //http:localhost:8082/api/inventory?skuCode=iphone-13&skuCode=iphone-13-red
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {

        return inventoryService.isInStock(skuCode);
    }

    
}
