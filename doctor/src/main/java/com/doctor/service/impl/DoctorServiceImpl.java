package com.doctor.service.impl;

import com.doctor.model.Doctor;
import com.doctor.repository.DoctorRepository;
import com.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

  @Autowired
  private DoctorRepository doctorRepository;

  @Override
  public List<Doctor> getAllDoctors() {
    return doctorRepository.findAll();
  }

  @Override
  public Doctor createDoctor(Doctor doctor) {
    return doctorRepository.save(doctor);
  }

  @Override
  public Optional<Doctor> getDoctorById(Long id) {
    return doctorRepository.findById(id);
  }

  @Override
  public Doctor updateDoctor(Long id, Doctor doctorDetails) throws Exception {
    Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new Exception("Doctor not found"));
    doctor.setName(doctorDetails.getName());
    doctor.setSpecialization(doctorDetails.getSpecialization());
    doctor.setPhoneNumber(doctorDetails.getPhoneNumber());
    doctor.setEmail(doctorDetails.getEmail());
    return doctorRepository.save(doctor);
  }

  @Override
  public void deleteDoctor(Long id) {
    doctorRepository.deleteById(id);
  }
}
