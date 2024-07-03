package com.hospital.service;

import com.hospital.model.Prescription;

import java.util.List;
import java.util.Optional;

public interface PrescriptionService {
  List<Prescription> getAllPrescriptions();
  Prescription createPrescription(Prescription prescription);
  Optional<Prescription> getPrescriptionById(Long id);
  Prescription updatePrescription(Long id, Prescription prescriptionDetails) throws Exception;
  void deletePrescription(Long id) throws Exception;
}
