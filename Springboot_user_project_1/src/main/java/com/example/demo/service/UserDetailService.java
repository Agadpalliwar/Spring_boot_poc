package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Dao.UserDetails;

public interface UserDetailService {
	
	   //to get the list of user
		List<UserDetails> getAllUsersDetail();
		
		//method for add the UserDetails
		void saveUserDetails(UserDetails userDetails);
		
		//method for delete userDetails.
		UserDetails deleteUserDetailsById(long id);
		
		//method for update employee
		UserDetails getUserDetailsById(long id);
		

}
