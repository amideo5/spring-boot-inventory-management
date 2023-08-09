package com.practice.practice.repo;

import com.practice.practice.model.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Orders, String> {
    Orders findByTrackId(String trackId);
}
