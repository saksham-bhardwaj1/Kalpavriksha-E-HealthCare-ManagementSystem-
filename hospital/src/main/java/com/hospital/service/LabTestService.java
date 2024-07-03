package com.hospital.service;

import com.hospital.model.LabTest;

import java.util.List;
import java.util.Optional;

public interface LabTestService {
  List<LabTest> getAllLabTests();
  LabTest createLabTest(LabTest labTest);
  Optional<LabTest> getLabTestById(Long id);
  LabTest updateLabTest(Long id, LabTest labTestDetails) throws Exception;
  void deleteLabTest(Long id) throws Exception;
}
