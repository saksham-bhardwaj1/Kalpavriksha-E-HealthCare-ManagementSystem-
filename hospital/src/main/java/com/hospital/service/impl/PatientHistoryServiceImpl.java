package com.hospital.service.impl;

import com.hospital.model.PatientHistory;
import com.hospital.repository.PatientHistoryRepository;
import com.hospital.service.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService {

  @Autowired
  private PatientHistoryRepository repository;

  @Override
  public List<PatientHistory> getHistoryByPatientId(Long patientId) {
    return repository.findByPatientId(patientId);
  }

  @Override
  public PatientHistory savePatientHistory(PatientHistory history) {
    return repository.save(history);
  }
}
