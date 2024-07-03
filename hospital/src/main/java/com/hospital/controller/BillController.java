package com.hospital.controller;

import com.hospital.model.Bill;
import com.hospital.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bills")
public class BillController {

  @Autowired
  private BillService billService;

  @GetMapping
  public List<Bill> getAllBills() {
    return billService.getAllBills();
  }

  @PostMapping
  public Bill createBill(@RequestBody Bill bill) {
    return billService.createBill(bill);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
    Optional<Bill> bill = billService.getBillById(id);
    return bill.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Bill> updateBill(@PathVariable Long id, @RequestBody Bill billDetails) throws Exception {
    Bill updatedBill = billService.updateBill(id, billDetails);
    return ResponseEntity.ok(updatedBill);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBill(@PathVariable Long id) throws Exception {
    billService.deleteBill(id);
    return ResponseEntity.noContent().build();
  }
}
