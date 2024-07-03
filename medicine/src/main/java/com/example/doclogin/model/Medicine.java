package com.example.doclogin.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
