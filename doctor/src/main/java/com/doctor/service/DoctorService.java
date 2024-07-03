package com.doctor.service;

import com.doctor.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
  List<Doctor> getAllDoctors();
  Doctor createDoctor(Doctor doctor);
  Optional<Doctor> getDoctorById(Long id);
  Doctor updateDoctor(Long id, Doctor doctorDetails) throws Exception;
  void deleteDoctor(Long id);
}
