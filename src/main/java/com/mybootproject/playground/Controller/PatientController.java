package com.mybootproject.playground.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootproject.playground.Repository.PatientRepository;

import com.mybootproject.playground.model.Patient;

@RestController
public class PatientController {
	
	@Autowired
	PatientRepository patientRepository;
	
	@PostMapping("/patient")
    public void insertPatient(@RequestBody Patient patient) {
        patientRepository.save(patient);
    }
	
	@GetMapping("/patient")
    public List<Patient> getAllPatient() {
        List<Patient> list = patientRepository.findAll();
        return list;
    }
	
	@GetMapping("/patient/one/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        Optional<Patient> optional = patientRepository.findById(id);
        if(!optional.isPresent())
            throw new RuntimeException("Invalid ID Given");
        
        Patient p = optional.get();
        return p; 
    }
	
	@DeleteMapping("/patient/{id}")
    public void deletePatient(@PathVariable("id") Long id) {
        patientRepository.deleteById(id);
    }
	
	 @PutMapping("/patient/{id}")
	    public Patient editPatient(@PathVariable("id") Long id, @RequestBody Patient newPatient) {
	        Optional<Patient> optional = patientRepository.findById(id);
	        
	        if(!optional.isPresent())
	            throw new RuntimeException("Invalid ID Given");
	        
	        Patient oldPatient = optional.get();
	        
	        oldPatient.setName(newPatient.getName());
	        oldPatient.setAddress(newPatient.getAddress());
	        oldPatient.setAge(newPatient.getAge());
	        oldPatient.setWeight(newPatient.getWeight());
	        oldPatient.setContact(newPatient.getContact());
	        oldPatient.setSex(newPatient.getSex());
	        
	        return patientRepository.save(oldPatient);
	    
	    }
	


}
