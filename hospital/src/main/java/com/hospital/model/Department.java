package com.hospital.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "department_")
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String location;
}
