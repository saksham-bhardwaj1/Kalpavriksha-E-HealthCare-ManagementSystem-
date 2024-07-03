package com.hospital.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="nurse")
public class Nurse {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String shift;
  private String phoneNumber;
}
