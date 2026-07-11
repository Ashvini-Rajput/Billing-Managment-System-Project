package com.billing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.entity.Bill;
import com.billing.repository.BillRepository;

//@Service
//public class BillService {
//
//    @Autowired
//    private BillRepository billRepository;
//
//    // Add bill and calculate total
//    public Bill saveBill(String itemName, int quantity, double price) {
//
//        Bill bill = new Bill();
//
//        bill.setItemName(itemName);
//        bill.setQuantity(quantity);
//        bill.setPrice(price);
//        bill.setTotal(price * quantity);
//
////        double total = quantity * price;
////        bill.setTotal(total);
//
//        return billRepository.save(bill);
//    }
//
//    // Get all bills
//    public List<Bill> getAllBills() {
//        return billRepository.findAll();
//    }
//
//    // Get bill by id
//    public Bill getBillById(Long id) {
//        return billRepository.findById(id).orElse(null);
//    }
//
//    // Delete bill
//    public void deleteBill(Long id) {
//        billRepository.deleteById(id);
//    }
//}


@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Bill saveBill(String itemName, int quantity, double price) {

        Bill bill = new Bill();

        bill.setItemName(itemName);
        bill.setQuantity(quantity);
        bill.setPrice(price);
        bill.setTotal(price * quantity);

        return billRepository.save(bill);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(Long id) {
        return billRepository.findById(id).orElse(null);
    }
    
    public void deleteBill(Long id) {
     billRepository.deleteById(id);
  }
    
    
    public Bill updateQuantity(Long id, int quantity) {

        Bill bill = billRepository.findById(id).orElse(null);

        if(bill != null){

            bill.setQuantity(quantity);

            double total = bill.getPrice() * quantity;

            bill.setTotal(total);

            return billRepository.save(bill);
        }

        return null;
    }

    // THIS IS REQUIRED METHOD
    public double getGrandTotal() {

        List<Bill> bills = billRepository.findAll();

        double total = 0;

        for(Bill bill : bills) {
            total += bill.getTotal();
        }

        return total;
    }
}