package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Dao.UserDetails;
import com.example.demo.model.Dao.UserMaster;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {

	

	List<UserDetails> findAll();

	

	Optional<UserDetails> findById(long id);
	
	
	List<UserDetails> findByEmail(String email);



	



	


	



	//Iterable<UserMaster> findUserByFirstName(String firstName);



	



	



	
  

	



	
	

}
