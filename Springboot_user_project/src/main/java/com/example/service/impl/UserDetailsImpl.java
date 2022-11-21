package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Dao.UserDetails;
import com.example.repository.UserDetailsRepository;
import com.example.service.UserDetailService;

public class UserDetailsImpl implements UserDetailService {
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Override
	public List<UserDetails> getAllUsersDetail() {
		return userDetailsRepository.findAll();	
	}

	@Override
	public void saveUserDetails(UserDetails userDetails) {
		this.userDetailsRepository.save(userDetails);
		
	}

	
// update
	@Override
	public UserDetails getUserDetailsById(long id) {
		Optional<UserDetails> optional = userDetailsRepository.findById(id);
		UserDetails userDetails= null;
		if(optional.isPresent()) {
			userDetails	=optional.get();
		}else {
			throw new RuntimeException("user not found for id = "+id);
		}
		return userDetails ;
	}

     @Override
     public UserDetails deleteUserDetailsById(long id) {
    	userDetailsRepository.deleteById(id);
	   return null;
}
	


}
