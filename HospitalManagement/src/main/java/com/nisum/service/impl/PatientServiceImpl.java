package com.nisum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.model.Patient;
import com.nisum.model.PatientDetails;
import com.nisum.repo.impl.PatientRepoImpl;
@Service
public class PatientServiceImpl {
	
	
	@Autowired
	PatientRepoImpl patientRepo;
	
	
	public void savePatient(PatientDetails patient)
	{
		patientRepo.save(patient);
		
	}
	
	public PatientDetails getPatient(Long id)
	{
		
		return patientRepo.get(id);
	}
	
	public List<PatientDetails> getPatientAll()
	{
		
		return patientRepo.getAll();
	}
	
	public void updatePatient(PatientDetails patientDetails)
	{
		
		patientRepo.update(patientDetails);
	}
	
	public void removePatient(Long id)
	{
		patientRepo.delete(id);
	}
	
	
	


}
