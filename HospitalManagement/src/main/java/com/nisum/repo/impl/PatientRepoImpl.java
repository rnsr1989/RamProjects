package com.nisum.repo.impl;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;
import com.nisum.model.Patient;


public class PatientRepoImpl {

	MongoTemplate mongotemplate;
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongotemplate = mongoTemplate;
	}
	
	
	//save pateint
	public void save(Patient pateint)
	{
		mongotemplate.save(pateint);
		
	}
	
	//get Patient
	public Patient get()
	{
		int id=0;
		return mongotemplate.findOne(new Query(Criteria.where("id").is(id)),
				Patient.class);
	}
	//get list of patients
	public List<Patient>  getAll()
	{
		return mongotemplate.findAll(Patient.class);
	}
	
	//remove pateient
	public void delete(String id) {
		mongotemplate.remove(new Query(Criteria.where("id").is(id)), Patient.class);
	}
	
	//update patient
	public WriteResult update(String id, String name) {
		return mongotemplate.updateFirst(
				new Query(Criteria.where("id").is(id)),
				Update.update("name", name), Patient.class);
	}
}
