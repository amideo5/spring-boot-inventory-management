package com.practice.practice.repo;

import com.practice.practice.model.Inventory;
import com.practice.practice.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
