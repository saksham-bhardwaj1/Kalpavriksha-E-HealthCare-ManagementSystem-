package com.hospital.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "medicines")
public class Medicine {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "drugName")
	private String drugName;
	@Column(name = "stock")
	private String stock;
  @Column(name = "price")
  private int price;
}
