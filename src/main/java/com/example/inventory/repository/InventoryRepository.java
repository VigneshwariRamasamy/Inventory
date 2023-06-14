package com.example.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.entity.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
