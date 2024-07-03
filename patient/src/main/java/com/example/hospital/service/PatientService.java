package com.example.hospital.service;

import com.example.hospital.model.Patient;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

public interface PatientService {
  List<Patient> getAllPatients();
  Patient createPatient(Patient patient);
  Patient getPatientById(Long id) throws Exception;
  Patient updatePatient(Long id, Patient patientDetails) throws Exception;
  Map<String, Boolean> deletePatient(Long id) throws Exception;

    Object generateBill(Long id, Model model);
}
