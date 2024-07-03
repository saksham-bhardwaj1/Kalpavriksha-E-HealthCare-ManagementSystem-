package com.hospital.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "prescription")
public class Prescription {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Long patientId;
  private Long doctorId;
  private String medicine;
  private String dosage;
  private Long medicineId;
  private String description;
}
