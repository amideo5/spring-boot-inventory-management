package com.practice.practice.service;

import com.practice.practice.Inbound_Data.Cart;
import com.practice.practice.Outbound_Data.DispatchItenary;
import com.practice.practice.constants.AppConstants;
import com.practice.practice.exception.ResourceNotFoundException;
import com.practice.practice.model.Inventory;
import com.practice.practice.model.Item;
import com.practice.practice.model.Orders;
import com.practice.practice.repo.InventoryRepository;
import com.practice.practice.repo.ItemRepository;
import com.practice.practice.repo.OrderRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    ItemRepository itemRepository;

    public String createBillNo(){
        return "#"+"150"+ RandomStringUtils.randomAlphanumeric(7);
    }

    public List<Orders> showOrder() { return this.orderRepository.findAll(); }

    /*public void updatedInventory_dec(Inventory inventoryDetail, int count){
        Inventory inventory = new Inventory();
        inventory.setAvailableUnits(inventoryDetail.getAvailableUnits()-count);
        inventory.setItemId(inventoryDetail.getItemId());
        inventoryRepository.save(inventory);
    }*/

    public void createOrder(Cart cart){

        Orders orders = new Orders();
        DispatchItenary dispatchItenary = new DispatchItenary();
        Map<String ,Integer> orderDetails = new HashMap<>();
        Map<String, Integer> map = cart.getItemList();
        for (Map.Entry mapElement : map.entrySet()) {
            Inventory inventory = inventoryRepository.findByItemId((String) mapElement.getKey());
            Item item = new Item();
            if ((int) mapElement.getValue()< 0) {

                throw new ResourceNotFoundException(AppConstants.QUANTITY_INVALID);

            } else if(inventory.getAvailableUnits() - (int) mapElement.getValue()< 0){

                throw new ResourceNotFoundException(AppConstants.ITEM_NOT_AVAILABLE);

            } else {
                String orderId = "#" + inventory.getItemId();

                orderDetails.put(orderId, (int) mapElement.getValue());
                //updatedInventory_dec(inventory, (int) mapElement.getValue());
                Inventory inventory1 = new Inventory();
                inventory1.setAvailableUnits(inventory.getAvailableUnits() - (int) mapElement.getValue());
                inventory1.setItemId(inventory.getItemId());
                inventoryRepository.save(inventory1);
            }
        }
        String billNo = createBillNo();
        orders.setTrackId(billNo);
        Map<String,String> dispatchMap = new HashMap<String, String>();
        dispatchMap.put(billNo, orderDetails.toString());
        dispatchItenary.setDispatchMap(dispatchMap);
        orders.setDispatchItenary(dispatchItenary);

        orderRepository.save(orders);
    }
}
