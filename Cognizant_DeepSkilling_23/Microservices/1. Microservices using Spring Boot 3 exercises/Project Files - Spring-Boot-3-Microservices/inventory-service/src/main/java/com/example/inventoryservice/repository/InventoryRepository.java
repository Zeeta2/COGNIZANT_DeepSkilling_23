package com.example.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.inventoryservice.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}