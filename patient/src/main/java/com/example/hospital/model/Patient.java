package com.example.hospital.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "patientdb")
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "first_name")
	private String name;
	@Column(name = "age")
	private String age;
	@Column(name = "blood_group")
	private String blood;
	@Column(name = "prescription")
	private String prescription;
	@Column(name = "dose")
	private String dose;
	@Column(name = "fees")
	private String fees;
	@Column(name = "urgency")
	private String urgency;
}
