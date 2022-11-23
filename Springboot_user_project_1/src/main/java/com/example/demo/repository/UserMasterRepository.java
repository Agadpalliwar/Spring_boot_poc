package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Dao.UserMaster;


@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster, Long>{

	

	Object findByUserName(String username);

	

	
	


}
