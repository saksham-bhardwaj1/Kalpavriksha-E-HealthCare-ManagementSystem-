package com.example.doclogin.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="appointment")
public class Appointment {
	@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="patient_name")
	private String patientName;
  @Column(name="doctor_name")
  private String doctorName;
	@Column(name="age")
	private String age;
	@Column(name="symptoms")
	private String symptoms;
	@Column(name="phone_number")
	private String phoneNumber;
  @Column(name="date")
  private String date;
  @Enumerated(EnumType.STRING)
  private TimeSlot timeSlot;
  private Long doctorId;
  private Long patientId;
}
