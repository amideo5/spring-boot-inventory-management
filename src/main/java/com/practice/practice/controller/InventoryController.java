package com.practice.practice.controller;

import com.practice.practice.Inbound_Data.AddTo;
import com.practice.practice.constants.ApiMapper;
import com.practice.practice.model.Inventory;
import com.practice.practice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping(ApiMapper.GET_INVENTORY)
    public ResponseEntity getInventory(@RequestBody Inventory inventory) {
        return ResponseEntity.ok().body(inventoryService.showInventory());
    }
    @PutMapping(ApiMapper.INVENTORY_PUT)
    public ResponseEntity updateInventory(@RequestBody AddTo addTo){
        inventoryService.changeInventory(addTo);
        return ResponseEntity.ok().body(inventoryService.showInventory());
    }
    @PostMapping(ApiMapper.INVENTORY_POST)
    public ResponseEntity newInventory(@RequestBody Inventory inventory){
        inventoryService.addInventory(inventory);
        return  ResponseEntity.ok().body(inventoryService.showInventory());
    }

}
