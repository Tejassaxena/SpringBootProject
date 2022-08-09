package com.mybootproject.playground.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootproject.playground.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
