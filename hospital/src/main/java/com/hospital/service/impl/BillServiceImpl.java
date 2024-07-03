package com.hospital.service.impl;

import com.hospital.model.Bill;
import com.hospital.repository.BillRepository;
import com.hospital.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {

  @Autowired
  private BillRepository billRepository;

  @Override
  public List<Bill> getAllBills() {
    return billRepository.findAll();
  }

  @Override
  public Bill createBill(Bill bill) {
    return billRepository.save(bill);
  }

  @Override
  public Optional<Bill> getBillById(Long id) {
    return billRepository.findById(id);
  }

  @Override
  public Bill updateBill(Long id, Bill billDetails) throws Exception {
    Bill bill = billRepository.findById(id)
      .orElseThrow(() -> new Exception("Bill not found with id: " + id));

    bill.setPatientId(billDetails.getPatientId());
    bill.setAmount(billDetails.getAmount());
    bill.setPaymentStatus(billDetails.getPaymentStatus());

    return billRepository.save(bill);
  }

  @Override
  public void deleteBill(Long id) throws Exception {
    Bill bill = billRepository.findById(id)
      .orElseThrow(() -> new Exception("Bill not found with id: " + id));

    billRepository.delete(bill);
  }
}
