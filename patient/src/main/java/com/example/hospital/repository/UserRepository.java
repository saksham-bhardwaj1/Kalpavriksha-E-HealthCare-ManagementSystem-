package com.example.hospital.repository;

import com.example.hospital.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  boolean existsByUsername(String username);

  User findByUsername(String username);

  List<User> findAllByType(String type);
}
