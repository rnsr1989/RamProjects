package com.nisum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.util.UriComponentsBuilder;

import com.nisum.model.User;
import com.nisum.service.UserService;
import com.nisum.service.impl.LoginServiceImpl;

@Controller
public class LoginController {
	
	
	@Autowired
	UserService userService;
	@Autowired
	LoginServiceImpl loginService;
	
	//...........login page...............
	@RequestMapping("/")
	public String hello()
	{
		System.out.println("Inside heelo22222");
		return "login";
	}
	
    //.................registration page.............
	
	
	
	
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(@RequestBody User user)
	{
		
		String login="";
		System.out.println("Inside heelo22222");
		User getuser=(User)loginService.check(user);
		if(getuser !=null)
			login="success";
		else
			login="login";
		System.out.println("login="+login);
		return login;
	}
	
	 //-------------------Create a User--------------------------------------------------------
    
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getFirstName());
        
        //user.setId(1);
        
        loginService.insert(user);
      
       System.out.println("Creating User after call  " + user.getLastName());
        HttpHeaders headers = new HttpHeaders();
       // headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
