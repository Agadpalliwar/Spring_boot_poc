package com.example.demo.service;

import com.example.demo.model.Dao.UserMaster;
import com.example.demo.model.Dto.UserRequest;

public interface UserMasterService {
	
	void saveUser(UserRequest userRequest);

	static UserRequest getUserDetailsById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	static Iterable<UserMaster> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
