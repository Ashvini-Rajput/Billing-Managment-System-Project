package com.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.billing.entity.Bill;
import com.billing.service.BillService;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillService billService;

    // Add bill
    @GetMapping("/add")
    public Bill addBill(
            @RequestParam String itemName,
            @RequestParam int quantity,
            @RequestParam double price) {

        return billService.saveBill(itemName, quantity, price);
    }

    // Get all bills
    @GetMapping("/all")
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    // Get bill by id
    @GetMapping("/get")
    public Bill getBillById(@RequestParam Long id) {
        return billService.getBillById(id);
    }

    // Delete bill
    @GetMapping("/delete")
    public String deleteBill(@RequestParam Long id) {
        billService.deleteBill(id);
        return "Bill deleted successfully";
    }
    
    
    
    @PutMapping("/update")
    public Bill updateBill(
            @RequestParam Long id,
            @RequestParam int quantity) {

        return billService.updateQuantity(id, quantity);
    }
    
    @GetMapping("/total")
    public double getGrandTotal() {
        return billService.getGrandTotal();
    }
    
}