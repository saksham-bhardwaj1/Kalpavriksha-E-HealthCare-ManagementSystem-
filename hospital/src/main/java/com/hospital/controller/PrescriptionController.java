package com.hospital.controller;

import com.hospital.model.Prescription;
import com.hospital.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

  @Autowired
  private PrescriptionService prescriptionService;

  @GetMapping
  public List<Prescription> getAllPrescriptions() {
    return prescriptionService.getAllPrescriptions();
  }

  @PostMapping
  public Prescription createPrescription(@RequestBody Prescription prescription) {
    return prescriptionService.createPrescription(prescription);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
    Optional<Prescription> prescription = prescriptionService.getPrescriptionById(id);
    return prescription.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescriptionDetails) throws Exception {
    Prescription updatedPrescription = prescriptionService.updatePrescription(id, prescriptionDetails);
    return ResponseEntity.ok(updatedPrescription);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePrescription(@PathVariable Long id) throws Exception {
    prescriptionService.deletePrescription(id);
    return ResponseEntity.noContent().build();
  }
}
