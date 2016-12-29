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
		System.out.println("save patient");
		patientRepo.save(patient);
		
	}
	
	public PatientDetails getPatient(Long id)
	{
		System.out.println("getpatient");
		return patientRepo.get(id);
	}
	
	public List<PatientDetails> getPatientAll()
	{
		System.out.println("getpatientAll");
		return patientRepo.getAll();
	}
	
	public void updatePatient(PatientDetails patientDetails)
	{
		System.out.println("updatePatient");
		patientRepo.update(patientDetails);
	}
	
	public void removePatient(Long id)
	{
		System.out.println("removePatient");
		patientRepo.delete(id);
	}
	
	public void removePatient(int id)
	{
		System.out.println("removePatient");
		//patientRepo.delete(id);
	}
	

	

}
