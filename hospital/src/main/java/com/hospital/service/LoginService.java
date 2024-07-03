package com.hospital.service;

import com.hospital.model.User;

import javax.naming.AuthenticationException;


public interface LoginService{
  User login(User user) throws AuthenticationException;
}
