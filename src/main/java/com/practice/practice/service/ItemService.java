package com.practice.practice.service;

import com.practice.practice.constants.AppConstants;
import com.practice.practice.exception.ResourceNotFoundException;
import com.practice.practice.model.Item;
import com.practice.practice.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void createItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> showItem() { return this.itemRepository.findAll(); }

    public void changeItem(Item item){
        Optional<Item> productDb = this.itemRepository.findById(item.getBaseId());

        if (productDb.isPresent()) {
            Item itemUpdate = productDb.get();
            itemUpdate.setBaseId(item.getBaseId());
            itemUpdate.setItemName(item.getItemName());
            itemUpdate.setPrice(item.getPrice());
            itemRepository.save(itemUpdate);
        } else {
            throw new ResourceNotFoundException(AppConstants.ITEM_INVALID);
        }
    }

}
