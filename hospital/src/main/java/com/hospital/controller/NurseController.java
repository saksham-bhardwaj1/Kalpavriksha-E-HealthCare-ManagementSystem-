package com.hospital.controller;

import com.hospital.model.Nurse;
import com.hospital.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nurses")
public class NurseController {

  @Autowired
  private NurseService nurseService;

  @GetMapping
  public List<Nurse> getAllNurses() {
    return nurseService.getAllNurses();
  }

  @PostMapping
  public Nurse createNurse(@RequestBody Nurse nurse) {
    return nurseService.createNurse(nurse);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Nurse> getNurseById(@PathVariable Long id) {
    Optional<Nurse> nurse = nurseService.getNurseById(id);
    return nurse.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Nurse> updateNurse(@PathVariable Long id, @RequestBody Nurse nurseDetails) throws Exception {
    Nurse updatedNurse = nurseService.updateNurse(id, nurseDetails);
    return ResponseEntity.ok(updatedNurse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteNurse(@PathVariable Long id) throws Exception {
    nurseService.deleteNurse(id);
    return ResponseEntity.noContent().build();
  }
}
