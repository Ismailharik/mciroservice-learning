package com.example.inventoryservice.repositories;

import com.example.inventoryservice.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findBySkuCodeIn(List<String> skuCode);
}
