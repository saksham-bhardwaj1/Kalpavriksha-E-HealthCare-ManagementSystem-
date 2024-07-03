package com.hospital.service.impl;

import com.hospital.model.Nurse;
import com.hospital.repository.NurseRepository;
import com.hospital.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NurseServiceImpl implements NurseService {

  @Autowired
  private NurseRepository nurseRepository;

  @Override
  public List<Nurse> getAllNurses() {
    return nurseRepository.findAll();
  }

  @Override
  public Nurse createNurse(Nurse nurse) {
    return nurseRepository.save(nurse);
  }

  @Override
  public Optional<Nurse> getNurseById(Long id) {
    return nurseRepository.findById(id);
  }

  @Override
  public Nurse updateNurse(Long id, Nurse nurseDetails) throws Exception {
    Nurse nurse = nurseRepository.findById(id)
      .orElseThrow(() -> new Exception("Nurse not found with id: " + id));

    nurse.setName(nurseDetails.getName());
    nurse.setShift(nurseDetails.getShift());
    nurse.setPhoneNumber(nurseDetails.getPhoneNumber());

    return nurseRepository.save(nurse);
  }

  @Override
  public void deleteNurse(Long id) throws Exception {
    Nurse nurse = nurseRepository.findById(id)
      .orElseThrow(() -> new Exception("Nurse not found with id: " + id));

    nurseRepository.delete(nurse);
  }
}
