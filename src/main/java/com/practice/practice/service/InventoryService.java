package com.practice.practice.service;

import com.practice.practice.Inbound_Data.AddTo;
import com.practice.practice.constants.AppConstants;
import com.practice.practice.exception.ResourceNotFoundException;
import com.practice.practice.model.Inventory;
import com.practice.practice.repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    public  void addInventory(Inventory inventory){

        if (inventory.getAvailableUnits() < 0){
            throw new ResourceNotFoundException(AppConstants.QUANTITY_INVALID);
        } else {
            inventoryRepository.save(inventory);
        }
    }

    public List<Inventory> showInventory() { return this.inventoryRepository.findAll(); }



    /*public void updatedInventory_inc(Inventory inventoryDetail, int count) {

        if (count<0){
            throw new ResourceNotFoundException(AppConstants.QUANTITY_INVALID);
        } else {
            Inventory inventory = new Inventory();
            inventory.setAvailableUnits(inventoryDetail.getAvailableUnits() + count);
            inventory.setItemId(inventoryDetail.getItemId());
            inventoryRepository.save(inventory);
        }
    }*/

    public void changeInventory(AddTo addTo){

        Map<String, Integer> map_two = addTo.getItem_toList();

        for (Map.Entry mapElement_two : map_two.entrySet()) {
            Inventory inventory = inventoryRepository.findByItemId((String) mapElement_two.getKey());
            //updatedInventory_inc(inventory, (int) mapElement_two.getValue());
            if ((int) mapElement_two.getValue() < 0){
                throw new ResourceNotFoundException(AppConstants.QUANTITY_INVALID);
            } else {
                Inventory inventory1 = new Inventory();
                inventory1.setAvailableUnits(inventory.getAvailableUnits() + (int) mapElement_two.getValue());
                inventory1.setItemId(inventory.getItemId());
                inventoryRepository.save(inventory1);
            }
        }
    }

}
