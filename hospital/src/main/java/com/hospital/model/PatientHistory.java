package com.hospital.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "patientHistory")
public class PatientHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Long patientId;
  private Long doctorId;
  private String diagnosis;
  private String treatment;
  private Date visitDate;
  private String doctorName;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "patientHistory_id")
  private List<Prescription> prescriptions;
}
