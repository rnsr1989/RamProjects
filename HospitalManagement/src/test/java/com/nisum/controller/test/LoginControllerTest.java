package com.nisum.controller.test;

import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriComponentsBuilder;

import com.nisum.controller.LoginController;
import com.nisum.model.User;
import com.nisum.service.impl.LoginServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
	
	
	
	@Mock
	private LoginServiceImpl loginService;
	
	@InjectMocks
	private LoginController loginController;
	
	private MockMvc mockMvc;
	
	private UriComponentsBuilder ucBuilder;
	private User user;
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
		user=new User();
		user.setId(1);
		user.setRole("USER");
     }
	
	@Test
	public void homeTest() throws Exception {
		mockMvc.perform(get("/.html")).andExpect(status().isOk());
		
	}	
	
	@Test
	public void adminTest() throws Exception {
		
		mockMvc.perform(get("/admin.html")).andExpect(status().isOk());
		
	}	
	@Test
	public void patientViewTest() throws Exception {
		
		mockMvc.perform(get("/patientPage")).andExpect(status().isOk());
		
	}
	
	/*@Test
	public void createUserTest() throws Exception {
		
	   mockMvc.perform(post("/registerUser")).andExpect(status().isOk());
	}*/
}
