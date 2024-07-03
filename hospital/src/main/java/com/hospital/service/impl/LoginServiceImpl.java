package com.hospital.service.impl;

import com.hospital.model.User;
import com.hospital.repository.UserRepository;
import com.hospital.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  UserRepository userRepository;
  @Override
  public User login(User user) throws AuthenticationException {
    if(userRepository.existsByUsername(user.getUsername())){
      User db = userRepository.findByUsername(user.getUsername());
      if(db.getPassword().equalsIgnoreCase(Base64.getEncoder().encodeToString(user.getPassword().getBytes(StandardCharsets.UTF_8)))){
        return db;
      }
      else{
        throw new AuthenticationException("Invalid Credentials");
      }
    }
    throw new AuthenticationException("No such user found");
  }
}
