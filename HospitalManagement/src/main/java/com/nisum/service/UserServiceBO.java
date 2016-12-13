package com.nisum.service;

import org.springframework.stereotype.Service;

import com.nisum.model.User;

@Service
public class UserServiceBO implements UserService {

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("inside User service bo class");
		return user;
	}

}
