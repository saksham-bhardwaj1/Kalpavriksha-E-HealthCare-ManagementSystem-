package com.hospital.controller;

import com.hospital.model.User;
import com.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.List;

@RestController
@RequestMapping("/admin")
//@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

  @Autowired
  UserService userService;
  @PostMapping()
  public User createUser(@RequestBody User user) throws AuthenticationException {
    return userService.createUser(user);
  }
  @PutMapping("/{id}")
  public User updateUser(@PathVariable Long id,@RequestBody User user){
    return userService.updateUser(id, user);
  }
  @GetMapping("/{id}")
  public User getUser(@PathVariable Long id){
    return userService.getUser(id);
  }
  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id){
    userService.deleteUser(id);
  }
  @GetMapping()
  public List<User> getUsers(@RequestParam String type){
    return userService.getList(type);
  }
}
