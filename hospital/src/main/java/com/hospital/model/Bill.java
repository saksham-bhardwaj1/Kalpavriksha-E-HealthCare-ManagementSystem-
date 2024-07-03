package com.hospital.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bill")
public class Bill {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Long patientId;
  private Double amount;
  private String paymentStatus;
}
