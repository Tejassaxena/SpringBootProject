package com.mybootproject.playground.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long appointment_Id;
	
	@Column(nullable = false)
	private String date;
	
	@Column(nullable = false)
	private String time;
	
	@ManyToOne
	private Doctor doctor;
	
	@ManyToOne
	private Patient patient;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(Long appointment_Id, String date, String time, Doctor doctor, Patient patient) {
		super();
		this.appointment_Id = appointment_Id;
		this.date = date;
		this.time = time;
		this.doctor = doctor;
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Appointment [appointment_Id=" + appointment_Id + ", date=" + date + ", time=" + time + ", doctor="
				+ doctor + ", patient=" + patient + "]";
	}

	public Long getAppointment_Id() {
		return appointment_Id;
	}

	public void setAppointment_Id(Long appointment_Id) {
		this.appointment_Id = appointment_Id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
