package com.doctor.controller;

import com.doctor.model.Doctor;
import com.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DoctorController {

  @Autowired
  private DoctorService doctorService;

  @GetMapping("/doctors")
  public List<Doctor> getAllDoctors() {
    return doctorService.getAllDoctors();
  }

  @PostMapping("/doctors")
  public Doctor createDoctor(@RequestBody Doctor doctor) {
    return doctorService.createDoctor(doctor);
  }

  @GetMapping("/doctors/{id}")
  public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
    Optional<Doctor> doctor = doctorService.getDoctorById(id);
    return doctor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PutMapping("/doctors/{id}")
  public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) throws Exception {
    Doctor updatedDoctor = doctorService.updateDoctor(id, doctorDetails);
    return ResponseEntity.ok(updatedDoctor);
  }

  @DeleteMapping("/doctors/{id}")
  public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
    doctorService.deleteDoctor(id);
    return ResponseEntity.noContent().build();
  }
}
