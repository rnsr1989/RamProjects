package com.nisum.config;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
	
@RequestMapping("/login")
public String viewLogin()
{
	
  System.out.println("enter");
return "hello";
}




}
