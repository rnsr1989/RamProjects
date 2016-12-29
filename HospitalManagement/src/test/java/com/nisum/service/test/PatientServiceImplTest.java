package com.nisum.service.test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.nisum.model.PatientDetails;
import com.nisum.repo.impl.PatientRepoImpl;
import com.nisum.service.impl.PatientServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class PatientServiceImplTest {
	
	@Mock
	private PatientRepoImpl patientRepo;
	
	@InjectMocks
    private PatientServiceImpl patientServiceImpl;
    
    
   private List<PatientDetails> listPatients;
    
   private PatientDetails  patientDetails;
    @Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

    
    
    @Test
	public void getPatientAll() throws Exception {
		
    	when(patientServiceImpl.getPatientAll()).thenReturn(listPatients);

	}
    
    @Test
	public void updatePatientTest() throws Exception {
    	
    	patientServiceImpl.updatePatient(any(PatientDetails.class));
	}
    
    @Test
	public void removePatientTest() throws Exception {
		
        patientServiceImpl.removePatient(any(Long.class));
	}
    @Test
   	public void getPatientTest() throws Exception {
   		
           patientServiceImpl.getPatient(any(Long.class));
           when(patientServiceImpl.getPatient(any(Long.class))).thenReturn(patientDetails);
   	}
    @Test
    public void savePatientTest() throws Exception {
   		
        patientServiceImpl.savePatient(any(PatientDetails.class));
	}
}
