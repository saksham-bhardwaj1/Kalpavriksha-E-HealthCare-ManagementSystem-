package com.hospital.service;

import com.hospital.model.User;

import javax.naming.AuthenticationException;
import java.util.List;

public interface UserService {
  User createUser(User user) throws AuthenticationException;
  void deleteUser(Long id);
  User updateUser(Long id, User user);
  List<User> getList(String type);

  User getUser(Long id);
}
