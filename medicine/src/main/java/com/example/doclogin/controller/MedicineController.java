package com.example.doclogin.controller;

import java.util.List;
import java.util.Map;

import com.example.doclogin.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doclogin.model.Medicine;

@RestController
//@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/v2/")
public class MedicineController {

  @Autowired
  private MedicineService medicineService;

  @GetMapping("/medicines")
  public List<Medicine> getAllMedicines() {
    return medicineService.getAllMedicines();
  }

  @PostMapping("/medicines")
  public Medicine createMedicine(@RequestBody Medicine medicine) {
    return medicineService.createMedicine(medicine);
  }

  @GetMapping("/medicines/{id}")
  public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) throws Exception {
    Medicine medicine = medicineService.getMedicineById(id);
    return ResponseEntity.ok(medicine);
  }

  @PutMapping("/medicines/{id}")
  public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicineDetails) throws Exception {
    Medicine updatedMedicine = medicineService.updateMedicine(id, medicineDetails);
    return ResponseEntity.ok(updatedMedicine);
  }

  @DeleteMapping("/medicines/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable Long id) throws Exception {
    Map<String, Boolean> response = medicineService.deleteMedicine(id);
    return ResponseEntity.ok(response);
  }
}
