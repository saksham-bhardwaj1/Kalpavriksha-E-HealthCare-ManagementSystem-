package com.hospital.service.impl;

import com.hospital.model.PatientHistory;
import com.hospital.model.User;
import com.hospital.repository.PatientHistoryRepository;
import com.hospital.repository.UserRepository;
import com.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;
  @Autowired
  PatientHistoryRepository patientHistoryRepository;
  @Override
  public User createUser(User user) throws AuthenticationException {
    if(userRepository.existsByUsername(user.getUsername())){
      throw new AuthenticationException("User already exists with this username");
    }
    user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes(StandardCharsets.UTF_8)));

    User dbUser = userRepository.save(user);
//    if(user.getType().equalsIgnoreCase("user")){
//      createPatientHistory(dbUser);
//    }
    return dbUser;
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);

  }

  @Override
  public User updateUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public List<User> getList(String type) {
    return userRepository.findAllByType(type);
  }

  @Override
  public User getUser(Long id) {
    return userRepository.findById(id).get();
  }

  void createPatientHistory(User user){
    PatientHistory patientHistory = new PatientHistory();
    patientHistory.setPatientId(user.getId());
    patientHistory.setVisitDate(new Date());
    patientHistoryRepository.save(patientHistory);

  }
}
