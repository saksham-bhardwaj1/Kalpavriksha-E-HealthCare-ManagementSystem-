package com.example.doclogin.service.impl;

import com.example.doclogin.model.Medicine;
import com.example.doclogin.repository.MedicineRepository;
import com.example.doclogin.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedicineServiceImpl implements MedicineService {

  @Autowired
  private MedicineRepository medicineRepository;

  @Override
  public List<Medicine> getAllMedicines() {
    return medicineRepository.findAll();
  }

  @Override
  public Medicine createMedicine(Medicine medicine) {
    return medicineRepository.save(medicine);
  }

  @Override
  public Medicine getMedicineById(Long id) throws Exception {
    return medicineRepository.findById(id)
      .orElseThrow(() -> new Exception("Medicine not found for this id :: " + id));
  }

  @Override
  public Medicine updateMedicine(Long id, Medicine medicineDetails) throws Exception {
    Medicine medicine = medicineRepository.findById(id)
      .orElseThrow(() -> new Exception("Medicine not found for this id :: " + id));

    medicine.setDrugName(medicineDetails.getDrugName());
    medicine.setStock(medicineDetails.getStock());
    medicine.setId(medicineDetails.getId());

    return medicineRepository.save(medicine);
  }

  @Override
  public Map<String, Boolean> deleteMedicine(Long id) throws Exception {
    Medicine medicine = medicineRepository.findById(id)
      .orElseThrow(() -> new Exception("Medicine not found for this id :: " + id));

    medicineRepository.delete(medicine);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
