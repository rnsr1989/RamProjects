package com.nisum.repo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.nisum.model.Patient;
import com.nisum.model.PatientDetails;
import com.nisum.model.User;

@Repository
public class PatientRepoImpl {

	@Autowired
	MongoTemplate mongotemplate;
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongotemplate = mongoTemplate;
	}
	
	
	//save pateint
	public void save(PatientDetails pateint)
	{
		
		List<PatientDetails> getUser= mongotemplate.findAll(PatientDetails.class);
		System.out.println("size="+getUser.size());
		
		pateint.setId(getUser.size()+1);
		mongotemplate.save(pateint);
		
	}
	
	//get Patient
	public PatientDetails get(Long id)
	{
		return mongotemplate.findOne(new Query(Criteria.where("id").is(id)),
				PatientDetails.class);
	}
	//get list of patients
	public List<PatientDetails>  getAll()
	{
		return mongotemplate.findAll(PatientDetails.class);
	}
	
	//remove pateient
	public void delete(Long id) {
		System.out.println("before delete");
		mongotemplate.remove(new Query(Criteria.where("id").is(id)), PatientDetails.class);
		System.out.println("successfully deleted");
	}
	
	//update patient
	public void update(PatientDetails patientDetails) {
//		return mongotemplate.updateFirst(
//				new Query(Criteria.where("id").is(id)),
//				Update.update("name", name), Patient.class);
		
		mongotemplate.save(patientDetails);
	}
}
