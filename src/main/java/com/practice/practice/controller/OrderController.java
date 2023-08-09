package com.practice.practice.controller;

import com.practice.practice.Inbound_Data.Cart;
import com.practice.practice.constants.ApiMapper;
import com.practice.practice.model.Orders;
import com.practice.practice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(ApiMapper.GET_ORDER)
    public ResponseEntity getOrder(@RequestBody Orders orders) {
        return ResponseEntity.ok().body(orderService.showOrder());
    }
    @PostMapping(ApiMapper.POST_ORDER)
    public ResponseEntity createOrder(@RequestBody Cart cart) {
        orderService.createOrder(cart);
        return ResponseEntity.ok().body(orderService.showOrder());
    }






}


