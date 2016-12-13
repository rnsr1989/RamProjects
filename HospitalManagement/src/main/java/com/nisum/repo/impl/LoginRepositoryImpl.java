package com.nisum.repo.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nisum.model.User;



@Repository
public class LoginRepositoryImpl {
	@Autowired
	MongoTemplate mongoTemplate;

	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public void saveUser(User user) {
		
		List<User> getUser= mongoTemplate.findAll(User.class);
		System.out.println("size="+getUser.size());
		
		user.setId(getUser.size()+1);
		
		//mongoTemplate.insert(user);
		mongoTemplate.save(user);
		System.out.println("sucessfully inserted");
	}
	public void getUserInfo()
	{
		
		User user=(User) mongoTemplate.findOne(new Query(Criteria.where("id").is("1")),
					User.class);
	}
	
	public  void getAllUserInfo() {
		System.out.println("repo");
		List<User> user= mongoTemplate.findAll(User.class);
		
		for (User userInfo : user) {
			
	}
}
	
	public User checkLogin(User user)
	{System.out.println(user.getUsername());
	System.out.println(user.getPassword());
		System.out.println("checkLogin");
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(user.getUsername()).and("password").is(user.getPassword()));
		User getuser=(User)mongoTemplate.findOne(query, User.class);
		if(getuser !=null)
			System.out.println("loginsuccess");
		else
			System.out.println("loginfailure");
			
		return user;
		
	}
}
