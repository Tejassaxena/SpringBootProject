package com.mybootproject.playground.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootproject.playground.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	

}
