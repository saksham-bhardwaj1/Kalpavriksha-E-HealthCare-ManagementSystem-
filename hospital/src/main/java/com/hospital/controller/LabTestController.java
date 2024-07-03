package com.hospital.controller;

import com.hospital.model.LabTest;
import com.hospital.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/labtests")
public class LabTestController {

  @Autowired
  private LabTestService labTestService;

  @GetMapping
  public List<LabTest> getAllLabTests() {
    return labTestService.getAllLabTests();
  }

  @PostMapping
  public LabTest createLabTest(@RequestBody LabTest labTest) {
    return labTestService.createLabTest(labTest);
  }

  @GetMapping("/{id}")
  public ResponseEntity<LabTest> getLabTestById(@PathVariable Long id) {
    Optional<LabTest> labTest = labTestService.getLabTestById(id);
    return labTest.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<LabTest> updateLabTest(@PathVariable Long id, @RequestBody LabTest labTestDetails) throws Exception {
    LabTest updatedLabTest = labTestService.updateLabTest(id, labTestDetails);
    return ResponseEntity.ok(updatedLabTest);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLabTest(@PathVariable Long id) throws Exception {
    labTestService.deleteLabTest(id);
    return ResponseEntity.noContent().build();
  }
}
