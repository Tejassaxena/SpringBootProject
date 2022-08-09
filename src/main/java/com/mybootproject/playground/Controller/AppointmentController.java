package com.mybootproject.playground.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybootproject.playground.Repository.AppointmentRepository;
import com.mybootproject.playground.Repository.DoctorRepository;
import com.mybootproject.playground.Repository.PatientRepository;
import com.mybootproject.playground.model.Appointment;

import com.mybootproject.playground.model.Doctor;
import com.mybootproject.playground.model.Patient;




@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class AppointmentController {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@PostMapping("/appointment/{pid}/{did}")
    public Appointment postAppointment(@RequestBody Appointment appointment,
                            @PathVariable("pid") Long pid, 
                            @PathVariable("did") Long did) {
        
        Optional<Patient> optionalP =  patientRepository.findById(pid);
        if(!optionalP.isPresent())
            throw new RuntimeException("Patient ID invalid!!");
        
        Patient patient = optionalP.get();
        
        Optional<Doctor> optionalD = doctorRepository.findById(did);
        
        if(!optionalD.isPresent())
            throw new RuntimeException("Doctor ID invalid!!");
        
        Doctor doctor = optionalD.get();
        
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        
        return appointmentRepository.save(appointment);
    
    }
	
	@GetMapping("/appointment")
    public List<Appointment> getAllAppointment(@RequestParam("page") Integer page,
    		                                   @RequestParam("size") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
    	return appointmentRepository.findAll(pageable).getContent();
    	
    }
	
	 @GetMapping("/appointment/patient/{pid}")
	    public List<Appointment> getAppointmentByPatientId(@PathVariable("pid") Long pid) {
	    	 Optional<Patient> optionalP =  patientRepository.findById(pid);
	         if(!optionalP.isPresent())
	             throw new RuntimeException("Category ID invalid!!");
	         
	         List <Appointment> list = appointmentRepository.getAppointmentByPatientId(pid);
	         return list;
	         
	    	
	    }
	 
	 @GetMapping("/appointment/doctor/{did}")
	    public List<Appointment> getAppointmentByDoctorId(@PathVariable("did") Long did){
	    	 Optional<Doctor> optionalD = doctorRepository.findById(did);
	         
	         if(!optionalD.isPresent())
	             throw new RuntimeException("Vendor ID invalid!!");
	         
	         List <Appointment> list = appointmentRepository.getAppointmentByDoctorId(did);
	         return list;
	    }
	 
	 
	 @DeleteMapping("/appointment/patient/{pid}")
	    public void deleteAppointmentByPatientId(@PathVariable("pid") Long pid) {
	        Optional<Patient> optionalP =  patientRepository.findById(pid);
	        if(!optionalP.isPresent())
	            throw new RuntimeException("Patient ID invalid!!");
	        
	        appointmentRepository.deleteAppointmentByPatientId(pid);
	    }
	    
	
	


}
