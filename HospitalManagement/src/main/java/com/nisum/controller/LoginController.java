package com.nisum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.util.UriComponentsBuilder;

import com.nisum.model.User;
//import com.nisum.service.UserService;
import com.nisum.service.impl.LoginServiceImpl;
//https://www.youtube.com/watch?v=7TMuBxTy3GE
@Controller
public class LoginController {

//	@Autowired
//	UserService userService;
//	
	
	
	@Autowired
	LoginServiceImpl loginService;
	
	
	
	// ...........login page...............
	
	@RequestMapping("/")
	public String home() {
		System.out.println("home page");
		return "login";
	}

	// .................registration page.............

	@RequestMapping(value = "/login")
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
	}

	// -------------------Create a
	// User--------------------------------------------------------

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("get user " + user.getRole());

		// user.setId(1);
		//user.setRole("USER");
		loginService.insert(user);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping("/admin")
	public String admin() {
		System.out.println("admin");
		return "user";
		//return "patient";
	}

//	@RequestMapping(value ="/logout")
//	public String logout(HttpServletRequest request) {
//		System.out.println("logout");
//		request.getSession().invalidate();
//		return "login";
//	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
	@RequestMapping("/patientPage")
	public String patientView() {
		System.out.println("patientcontroller");
		return "patient";
	}
	
	

	
}
