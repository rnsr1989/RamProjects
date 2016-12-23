package com.nisum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.nisum.model.Patient;
import com.nisum.model.User;
import com.nisum.service.UserService;
import com.nisum.service.impl.LoginServiceImpl;
@RestController
public class UserRestController {
	//http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/
	
	@Autowired
	LoginServiceImpl loginService;
	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		System.out.println("enter");
		List<User> users =loginService.gerAllUser();
		//System.out.println(user.getUsername());
		if (users == null) {
            
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
		
		//create user
	
	@RequestMapping(value = "/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getFirstName());
        loginService.insert(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	
    //delete a user
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        User user = loginService.gerUser(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        //userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
	
	//retrieve single user
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        User user = loginService.gerUser(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
 
    
    
	
}
