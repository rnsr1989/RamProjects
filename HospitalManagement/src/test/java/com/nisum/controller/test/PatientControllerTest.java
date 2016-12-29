package com.nisum.controller.test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nisum.controller.PatientController;
import com.nisum.model.PatientDetails;
import com.nisum.service.impl.PatientServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
	@Mock
	private PatientServiceImpl patientService;
	
	
	
	@InjectMocks
	private PatientController patientController;
	//@Mock
	private Long id;
	@Mock
	private PatientDetails patient;
	//@Mock
	private List<PatientDetails> patientDetails;
	
	private PatientDetails patientObject;
	
	private MockMvc mockMvc;
	 static List<PatientDetails>  expectedPeople;
	 

	
	 
	    @Before
		public void setUp() throws Exception {
			MockitoAnnotations.initMocks(this);
			mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
			
		}
	 
	    
	
	
	     @Test
	     public void getAllTest() throws Exception {
	 
	         //mockMvc.perform(get("/getPatientAll.htm")).andExpect(status().isOk());
	    	 
	    	 Mockito.when(
	    			 patientService.getPatientAll()).thenReturn(
	    					 patientDetails);
	         mockMvc.perform(get("/getPatientAll.htm")).andExpect(status().isOk());
	         
	         
	         
	          }
	     @Test
	     public void getPatientTest() throws Exception {
	    	 Mockito.when(
	    			 patientService.getPatient(any(Long.class))).thenReturn(
	    					 patientObject);
	    	 
	         mockMvc.perform(get("/patient.htm")).andExpect(status().isOk());
	         
	         
	          }
/*
	     @Test
	     public void removeTest() throws Exception {
	     
	    	
	    patientController.remove(id);
	     }*/
	     
	     @Test
	     public void patientRegistrationTest() throws Exception {
	     
	    	     patientController.patientRegistration(patient);
	          }
	     
	     @Test
	     public void updateTest() throws Exception {
	     
	    	    // patientController.update(any(Long.class),any(PatientDetails.class));
	    	     //patientController.update(id,patient);
	    	 Mockito.when(
	    			 patientService.getPatient(any(Long.class))).thenReturn(
	    					 patientObject);
	    	//.perform(put("/updatePatient")).andExpect(status().isOk());
	          }

	   /*  @Test
	     public void removeTest() throws Exception {
	     
	    	String id="3";
	   // patientController.remove(id);
	    	 patientObject=new PatientDetails();
	    	 patientObject.setId(1);
	    	 
	    	 mockMvc.perform(
	    			 delete("/removePatient/id}",Long.parseLong(id)))
	    	            .andExpect(status().isOk());
	    	 
	    	
	     }*/
}
