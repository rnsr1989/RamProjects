package com.nisum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nisum.model.Patient;
import com.nisum.repo.impl.PatientRepoImpl;

public class PatientServiceImpl {
	
	
	@Autowired
	PatientRepoImpl patientRepo;
	
	
	public void savePatient(Patient patient)
	{
		patientRepo.save(patient);
		
	}
	
	public Patient getPatient()
	{
		
		return patientRepo.get();
	}
	
	public List<Patient> getPatientAll()
	{
		
		return patientRepo.getAll();
	}
	
	public void updatePatient(String id,String name)
	{
		
		patientRepo.update(id, name);
	}
	
	public void removePatient(String id)
	{
		patientRepo.delete(id);
	}
	
	
	


}
