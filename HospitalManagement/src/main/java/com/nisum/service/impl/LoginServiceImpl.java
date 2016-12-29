package com.nisum.service.impl;

import java.util.List;

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
	public User gerUser(Integer id)
	{
		
	  return repository.getUserInfo(id);	
	}
	public List<User> gerAllUser()
	{
		return repository.getAllUserInfo();	
	}
	
	public User check(String uname,String pwd)
	{
		
	
	return repository.checkLogin(uname,pwd);
	}
	
	
}
