package com.hospital.service.impl;

import com.hospital.model.Medicine;
import com.hospital.model.PatientHistory;
import com.hospital.model.Prescription;
import com.hospital.repository.MedicineRepository;
import com.hospital.repository.PatientHistoryRepository;
import com.hospital.repository.PrescriptionRepository;
import com.hospital.repository.UserRepository;
import com.hospital.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

  @Autowired
  private PrescriptionRepository prescriptionRepository;
  @Autowired
  PatientHistoryRepository patientHistoryRepository;
  @Autowired
  UserRepository userRepository;

  @Autowired
  MedicineRepository medicineRepository;

  @Override
  public List<Prescription> getAllPrescriptions() {
    return prescriptionRepository.findAll();
  }

  @Override
  public Prescription createPrescription(Prescription prescription) {
    Prescription dbPrescription = prescriptionRepository.save(prescription);
    addToPatientHistory(dbPrescription);
    return dbPrescription;
  }

  @Override
  public Optional<Prescription> getPrescriptionById(Long id) {
    return prescriptionRepository.findById(id);
  }

  @Override
  public Prescription updatePrescription(Long id, Prescription prescriptionDetails) throws Exception {
    Prescription prescription = prescriptionRepository.findById(id)
      .orElseThrow(() -> new Exception("Prescription not found with id: " + id));

    prescription.setPatientId(prescriptionDetails.getPatientId());
    prescription.setDoctorId(prescriptionDetails.getDoctorId());
    prescription.setMedicine(prescriptionDetails.getMedicine());
    prescription.setDosage(prescriptionDetails.getDosage());

    return prescriptionRepository.save(prescription);
  }

  @Override
  public void deletePrescription(Long id) throws Exception {
    Prescription prescription = prescriptionRepository.findById(id)
      .orElseThrow(() -> new Exception("Prescription not found with id: " + id));

    prescriptionRepository.delete(prescription);
  }

  void addToPatientHistory(Prescription prescription){
    PatientHistory patientHistory = new PatientHistory();
    patientHistory.setPrescriptions(Arrays.asList(prescription));
    patientHistory.setVisitDate(new Date());
    patientHistory.setDoctorName(userRepository.findById(prescription.getDoctorId()).get().getName());
    patientHistory.setPatientId(prescription.getPatientId());
    patientHistoryRepository.save(patientHistory);
    if(prescription.getMedicineId()!=null && prescription.getMedicineId()!=0){
      Medicine medicine = medicineRepository.findById(prescription.getMedicineId()).get();
      int total = Integer.parseInt(medicine.getStock());
      int sold = Integer.parseInt(prescription.getDosage());
      int left = total -sold;
      medicine.setStock(String.valueOf(left));
      medicineRepository.save(medicine);
    }
  }
}
