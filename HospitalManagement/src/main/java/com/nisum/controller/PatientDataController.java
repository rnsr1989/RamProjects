package com.nisum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.model.PatientDetails;
import com.nisum.model.User;
import com.nisum.repo.PatientRepository;
import com.nisum.service.impl.PatientServiceImpl;


//PatientDataController
@RestController
public class PatientDataController {
	@Autowired
	PatientServiceImpl patientService;
	
	
	@Autowired
	PatientRepository patientRepository;
	

	//get Patient Object
	@RequestMapping("/restauth/patient")
	public PatientDetails getPatient(Long id)
	{
		System.out.println("getpatinet");
		//patientRepository.findByUsername("ram");
	//	patientRepository.findByUsername("ram");
	return patientService.getPatient(id);
	}
	
	@RequestMapping("/restauth/patientRegistration")
	public void  patientRegistration(@RequestBody PatientDetails patient)
	{
		
		
		System.out.println("pateintregistraion2");
	    patientService.savePatient(patient);
		
	}
	
	@RequestMapping("/restauth/getPatientAll")
    public List<PatientDetails> getAll()
    {
	System.out.println("getPatientAll");
	
	 List<PatientDetails> patientDetails=patientService.getPatientAll();
	return patientDetails;
	//return patientService.getPatientAll();
    }
	
	@RequestMapping(value = "/restauth/removePatient/{id}", method = RequestMethod.DELETE)
	//@RequestMapping(value = "/removePatient/{id}" ,method = RequestMethod.DELETE)
    public void remove(@PathVariable("id")Long id)
    {
		System.out.println("remove controller");
           patientService.removePatient(id);
	
    }   
	//@RequestMapping(value = "/updatePatient/{id}", method = RequestMethod.PUT)
	
	@RequestMapping(value = "/restauth/updatePatient/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PatientDetails> update(@PathVariable("id") long id, @RequestBody PatientDetails patient)
    {
	
	PatientDetails currentPateint=(PatientDetails)patientService.getPatient(id);
	
	if(currentPateint==null) {
        System.out.println("User with id " + id + " not found");
        return new ResponseEntity<PatientDetails>(HttpStatus.NOT_FOUND);
    }
	
	currentPateint.setUsername(patient.getUsername());
	currentPateint.setAddress(patient.getAddress());
	currentPateint.setEmail(patient.getEmail());
	patientService.updatePatient(currentPateint);
	return new ResponseEntity<PatientDetails>(currentPateint, HttpStatus.OK);
	
    }
	
	
	
	
	
}
