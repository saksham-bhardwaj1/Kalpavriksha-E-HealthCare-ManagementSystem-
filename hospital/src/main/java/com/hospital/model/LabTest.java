package com.hospital.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "labTest")
public class LabTest {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String testName;
  private String result;
  private Long patientId;
  private Long doctorId;
}
