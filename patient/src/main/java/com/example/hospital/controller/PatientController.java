package com.example.hospital.controller;

import com.example.hospital.model.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/patient")
//@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PatientController {

  @Autowired
  private PatientService patientService;

  @PostMapping("/patients")
  public Patient createPatient(@RequestBody Patient patient) {
    return patientService.createPatient(patient);
  }

  @GetMapping("/patients")
  public List<Patient> getAllPatients() {
    return patientService.getAllPatients();
  }

  @GetMapping("/patients/{id}")
  public ResponseEntity<Patient> getPatientById(@PathVariable Long id) throws Exception {
    Patient patient = patientService.getPatientById(id);
    return ResponseEntity.ok(patient);
  }

  @PutMapping("/patients/{id}")
  public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) throws Exception {
    Patient updatedPatient = patientService.updatePatient(id, patientDetails);
    return ResponseEntity.ok(updatedPatient);
  }

  @DeleteMapping("/patients/{id}")
  public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id) throws Exception {
    Map<String, Boolean> response = patientService.deletePatient(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/patient/bill/{id}")
  public Object generateBill(@PathVariable Long id, Model model) throws Exception {
    return  patientService.generateBill(id, model);
  }
}
