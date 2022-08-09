package com.mybootproject.playground.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(nullable = false)
	private String name;
	
	
	@Column(nullable = false)
	private String specialization;
	
	@Column(nullable = false)
	private String mobile_no;
	
	
	@Column(nullable = false)
	private Double fees;


	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Doctor(Long id, String name, String specialization, String mobile_no, Double fees) {
		super();
		Id = id;
		this.name = name;
		this.specialization = specialization;
		this.mobile_no = mobile_no;
		this.fees = fees;
	}


	@Override
	public String toString() {
		return "Doctor [Id=" + Id + ", name=" + name + ", specialization=" + specialization + ", mobile_no=" + mobile_no
				+ ", fees=" + fees + "]";
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public String getMobile_no() {
		return mobile_no;
	}


	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}


	public Double getFees() {
		return fees;
	}


	public void setFees(Double fees) {
		this.fees = fees;
	}


	

}
