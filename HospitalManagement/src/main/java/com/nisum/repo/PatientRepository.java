package com.nisum.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nisum.model.User;
@RepositoryRestResource(collectionResourceRel = "/patientDetails", path = "/patientDetails")


public interface PatientRepository extends MongoRepository<User,Long> {
	
	public User findByUsername(@Param("username")String username);

	public List<User> findByFirstName(@Param("firstName")String firstName);
	
	public User findById(@Param("id")Integer id);

}



