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
import com.nisum.model.User;
import com.nisum.repo.impl.LoginRepositoryImpl;
import com.nisum.service.impl.LoginServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {
	
	@Mock
	private LoginRepositoryImpl repository;

	private User user;
	@InjectMocks
	private LoginServiceImpl loginServiceImpl;
	
	private List<User> users;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	   @Test
		public void getPatientAllTest() throws Exception {
			
	    	when(loginServiceImpl.gerAllUser()).thenReturn(users);

		}
	   @Test
		public void gerUserTest() throws Exception {
			
	    	when(loginServiceImpl.gerUser(any(Integer.class))).thenReturn(user);
        }
	   @Test
		public void checkTest() throws Exception {
		   
			when(loginServiceImpl.check(any(String.class),any(String.class))).thenReturn(user);
		}
	   @Test
	    public void insertTest() throws Exception {
	   		
		   loginServiceImpl.insert(any(User.class));
		}
	   
}
