package com.mybootproject.playground.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootproject.playground.Repository.DoctorRepository;
import com.mybootproject.playground.model.Doctor;
import com.mybootproject.playground.model.Patient;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class DoctorController {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@PostMapping("/doctor")
    public void insertDoctor(@RequestBody Doctor doctor) {
        doctorRepository.save(doctor);
    }
	
	@GetMapping("/doctor")
    public List<Doctor> getAllDoctor() {
        List<Doctor> list = doctorRepository.findAll();
        return list;
	
}
	
	@GetMapping("/doctor/one/{id}")
    public Doctor getDoctorById(@PathVariable("id") Long id) {
        Optional<Doctor> optional = doctorRepository.findById(id);
        if(!optional.isPresent())
            throw new RuntimeException("Invalid ID Given");
        
        Doctor d = optional.get();
        return d; 
}
	
	@DeleteMapping("/doctor/{id}")
    public void deleteDoctor(@PathVariable("id") Long id) {
        doctorRepository.deleteById(id);
    }
	
	@PutMapping("/doctor/{id}")
    public Doctor editDoctor(@PathVariable("id") Long id, @RequestBody Doctor newDoctor) {
        Optional<Doctor> optional = doctorRepository.findById(id);
        
        if(!optional.isPresent())
            throw new RuntimeException("Invalid ID Given");
        
        Doctor oldDoctor = optional.get();
        
        oldDoctor.setName(newDoctor.getName());
        oldDoctor.setSpecialization(newDoctor.getSpecialization());
        oldDoctor.setMobile_no(newDoctor.getMobile_no());
        oldDoctor.setFees(newDoctor.getFees());
        
        
        return doctorRepository.save(oldDoctor);
    
    }
}
