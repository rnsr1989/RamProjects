package com.nisum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.model.User;
import com.nisum.repo.impl.LoginRepositoryImpl;
import com.nisum.repo.impl.LoginRepositoryImpl;

@Service
public class LoginServiceImpl {
	
	@Autowired
	private LoginRepositoryImpl repository;
	public LoginRepositoryImpl getRepository() {
		return repository;
	}
	public void setRepository(LoginRepositoryImpl repository) {
		this.repository = repository;
	}
	public void insert(User user)
	{
		repository.saveUser(user);
	}
	public void gerUser()
	{
		repository.getUserInfo();	
	}
	public void gerAllUser()
	{
		repository.getAllUserInfo();	
	}
	
	public User check(User user)
	{
		
	
	return repository.checkLogin(user);
	}
}
