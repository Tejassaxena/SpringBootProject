package com.mybootproject.playground.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 99)
    private String name; 
    
	@Column(nullable = false, length = 99)
    private String address;
	
	@Column(nullable = false)
    private Integer age;
	
	@Column(nullable = false)
    private Integer  weight;
	
	@Column(nullable = false)
    private Long contact; 
	
	@Column(nullable = false)
    private String sex;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(Long id, String name, String address, Integer age, Integer weight, Long contact, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.weight = weight;
		this.contact = contact;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + ", weight=" + weight
				+ ", contact=" + contact + ", sex=" + sex + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	} 
    
}