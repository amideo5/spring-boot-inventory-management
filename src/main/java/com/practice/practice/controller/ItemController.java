package com.practice.practice.controller;

import com.practice.practice.constants.ApiMapper;
import com.practice.practice.model.Item;
import com.practice.practice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(ApiMapper.GET_ITEM)
    public ResponseEntity getItem(@RequestBody Item item) {

        return ResponseEntity.ok().body(itemService.showItem());
    }
    @PutMapping(ApiMapper.ITEM_PUT)
    public ResponseEntity updateItem(@RequestBody Item item){
        itemService.changeItem(item);
        return ResponseEntity.ok().body(itemService.showItem());
    }
    @PostMapping(ApiMapper.ITEM_POST)
    public ResponseEntity newItem(@RequestBody Item item){
        itemService.createItem(item);
        return ResponseEntity.ok().body(itemService.showItem());
    }

}
