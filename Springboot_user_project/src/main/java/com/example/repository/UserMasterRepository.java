package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Dao.UserDetails;
import com.example.model.Dao.UserMaster;
import com.example.model.Dto.UserRequest;

public interface UserMasterRepository extends JpaRepository<UserMaster, Long>{

	void saveAll(UserDetails userDetails);

	

	

	

	

}
