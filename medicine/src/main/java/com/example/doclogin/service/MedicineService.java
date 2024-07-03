package com.example.doclogin.service;

import com.example.doclogin.model.Medicine;

import java.util.List;
import java.util.Map;

public interface MedicineService {
  List<Medicine> getAllMedicines();
  Medicine createMedicine(Medicine medicine);
  Medicine getMedicineById(Long id) throws Exception;
  Medicine updateMedicine(Long id, Medicine medicineDetails) throws Exception;
  Map<String, Boolean> deleteMedicine(Long id) throws Exception;
}
