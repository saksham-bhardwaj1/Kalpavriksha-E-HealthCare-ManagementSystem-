package com.hospital.controller;

import com.hospital.model.PatientHistory;
import com.hospital.service.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient-history")
public class PatientHistoryController {

  @Autowired
  private PatientHistoryService service;

  @GetMapping("/{patientId}")
  public List<PatientHistory> getHistoryByPatientId(@PathVariable Long patientId) {
    return service.getHistoryByPatientId(patientId);
  }

  @PostMapping
  public PatientHistory savePatientHistory(@RequestBody PatientHistory history) {
    return service.savePatientHistory(history);
  }
}
