package com.billing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.entity.Item;
import com.billing.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Add item
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    // Get all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Get item by id
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    // Delete item
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    // Update item
    public Item updateItem(Long id, String name, double price, int quantity) {

        Item item = itemRepository.findById(id).orElse(null);

        if(item != null) {
            item.setName(name);
            item.setPrice(price);
            item.setQuantity(quantity);
            return itemRepository.save(item);
        }

        return null;
    }
}