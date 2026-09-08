package com.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.billing.entity.Item;
import com.billing.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Add item
    @GetMapping("/add")
    public Item addItem(
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam int quantity) {

        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setQuantity(quantity);

        return itemService.saveItem(item);
    }

    // Get all items
    @GetMapping("/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // Get item by id
    @GetMapping("/get")
    public Item getItemById(@RequestParam Long id) {
        return itemService.getItemById(id);
    }

    // Delete item
    @GetMapping("/delete")
    public String deleteItem(@RequestParam Long id) {
        itemService.deleteItem(id);
        return "Item deleted successfully";
    }

    // Update item
    @GetMapping("/update")
    public Item updateItem(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam int quantity) {

        return itemService.updateItem(id, name, price, quantity);
    }
}