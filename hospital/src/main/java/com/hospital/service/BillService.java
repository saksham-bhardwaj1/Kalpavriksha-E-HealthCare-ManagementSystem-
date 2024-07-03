package com.hospital.service;

import com.hospital.model.Bill;

import java.util.List;
import java.util.Optional;

public interface BillService {
  List<Bill> getAllBills();
  Bill createBill(Bill bill);
  Optional<Bill> getBillById(Long id);
  Bill updateBill(Long id, Bill billDetails) throws Exception;
  void deleteBill(Long id) throws Exception;
}
