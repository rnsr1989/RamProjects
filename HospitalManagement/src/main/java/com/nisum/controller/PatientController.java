package com.nisum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nisum.model.Patient;
import com.nisum.service.impl.PatientServiceImpl;

@Controller
public class PatientController {
	@Autowired
	PatientServiceImpl patientService;
	
	
	
	@RequestMapping("/patient")
	public String patientPage()
	{
		return "login";
	}
	
	@RequestMapping("/patientRegistration")
	public void  patientRegistration(Patient patient)
	{
		patientService.savePatient(patient);
		
	}
	@RequestMapping("/getPatient")
    public Patient get()
    {
	
	return patientService.getPatient();
    }
	
	@RequestMapping("/getPatientAll")
    public List<Patient> getAll()
    {
	
	return patientService.getPatientAll();
    }
	
	@RequestMapping("/removePatient")
    public void remove(String id)
    {
	patientService.removePatient(id);
	
    }   
	
	@RequestMapping("/updatePatient")
    public void update(String id,String name)
    {
	
	patientService.updatePatient(id, name);
    }


}
