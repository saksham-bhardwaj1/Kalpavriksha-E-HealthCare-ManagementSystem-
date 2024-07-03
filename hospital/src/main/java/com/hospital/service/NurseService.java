package com.hospital.service;

import com.hospital.model.Nurse;

import java.util.List;
import java.util.Optional;

public interface NurseService {
  List<Nurse> getAllNurses();
  Nurse createNurse(Nurse nurse);
  Optional<Nurse> getNurseById(Long id);
  Nurse updateNurse(Long id, Nurse nurseDetails) throws Exception;
  void deleteNurse(Long id) throws Exception;
}
