package com.practice.practice.repo;

import com.practice.practice.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
    Inventory findByItemId(String itemId);
}
