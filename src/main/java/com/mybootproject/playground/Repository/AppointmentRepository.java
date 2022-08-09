package com.mybootproject.playground.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mybootproject.playground.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    @Query("select a from Appointment a where a.patient.id=?1")
	List<Appointment> getAppointmentByPatientId(Long pid);
    
    
    @Query("select a from Appointment a where a.doctor.id=?1")
	List<Appointment> getAppointmentByDoctorId(Long did);

    
    @Query("delete from Appointment a where a.patient.id=?1")
	void deleteAppointmentByPatientId(Long pid);
    
    
   

}
