package com.doctor.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "doctor")
public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String specialization;
  private String phoneNumber;
  private String email;
}
