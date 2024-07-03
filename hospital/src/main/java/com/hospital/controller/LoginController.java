package com.hospital.controller;

import com.hospital.model.User;
import com.hospital.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/login")
//@CrossOrigin(allowedHeaders = "*", origins = "*")
public class LoginController {

  @Autowired
  LoginService loginService;

  @PostMapping()
  public User login(@RequestBody User user) throws AuthenticationException {
    return loginService.login(user);
  }
}
