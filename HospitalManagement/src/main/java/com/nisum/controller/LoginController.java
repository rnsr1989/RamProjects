package com.nisum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
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
	
	
	// ...........login page...............
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("home page");
		return "login";
	}

	// .................registration page.............

	/*@RequestMapping(value = "/login")
	public String login(HttpServletRequest request) {

		String login = "login";
		if (request.getParameter("uname") != null && request.getParameter("pwd") != null) {
			String uname = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			User getuser = (User) loginService.check(uname.trim(), pwd.trim());
			if (getuser != null && (getuser.getUsername() != null && getuser.getUsername().length() > 0))
				login = "patient";
		}

		return login;
		// return "login";
	}*/

	// -------------------Create a
	// User--------------------------------------------------------

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getFirstName());

		// user.setId(1);
		user.setRole("ADMIN");
		loginService.insert(user);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping(value ="/logout",method = RequestMethod.POST)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login";
	}

	@RequestMapping("/patientPage")
	public String patientView() {
		System.out.println("patientcontroller");
		return "patient";
	}
	@RequestMapping("/springCloudConfig")
	public String springCloudEx() {
		return "admin";
	}

}
