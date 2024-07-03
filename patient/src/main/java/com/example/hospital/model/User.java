package com.example.hospital.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
@Table(name = "user_data")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String username;
  private String password;
  private String name;
  private String gender;
  private String dob;
  private String type; //DOCTOR, RECEPTIONIST, ADMIN, USER
  private ArrayList<String> degreeOfAttachments;
  private int experience;
  private String qualifications;
  private String profilePhoto;
  @Column(name = "age")
  private int age;
  @Column(name = "blood")
  private String blood;
  @Column(name = "fees")
  private int fees;
}
