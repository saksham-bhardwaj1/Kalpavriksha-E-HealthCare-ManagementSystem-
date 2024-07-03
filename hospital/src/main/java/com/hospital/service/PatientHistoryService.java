package com.hospital.service;

import com.hospital.model.PatientHistory;

import java.util.List;

public interface PatientHistoryService {
  List<PatientHistory> getHistoryByPatientId(Long patientId);
  PatientHistory savePatientHistory(PatientHistory history);
}
