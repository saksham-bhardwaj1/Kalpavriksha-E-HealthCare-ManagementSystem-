package com.hospital.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "room")
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String roomNumber;
  private String type; // e.g., general, ICU
  private boolean isAvailable;
}
