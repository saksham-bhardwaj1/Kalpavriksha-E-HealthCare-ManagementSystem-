package com.hospital.service.impl;

import com.hospital.model.LabTest;
import com.hospital.repository.LabTestRepository;
import com.hospital.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabTestServiceImpl implements LabTestService {

  @Autowired
  private LabTestRepository labTestRepository;

  @Override
  public List<LabTest> getAllLabTests() {
    return labTestRepository.findAll();
  }

  @Override
  public LabTest createLabTest(LabTest labTest) {
    return labTestRepository.save(labTest);
  }

  @Override
  public Optional<LabTest> getLabTestById(Long id) {
    return labTestRepository.findById(id);
  }

  @Override
  public LabTest updateLabTest(Long id, LabTest labTestDetails) throws Exception {
    LabTest labTest = labTestRepository.findById(id)
      .orElseThrow(() -> new Exception("LabTest not found with id: " + id));

    labTest.setTestName(labTestDetails.getTestName());
    labTest.setResult(labTestDetails.getResult());
    labTest.setPatientId(labTestDetails.getPatientId());
    labTest.setDoctorId(labTestDetails.getDoctorId());

    return labTestRepository.save(labTest);
  }

  @Override
  public void deleteLabTest(Long id) throws Exception {
    LabTest labTest = labTestRepository.findById(id)
      .orElseThrow(() -> new Exception("LabTest not found with id: " + id));

    labTestRepository.delete(labTest);
  }
}
