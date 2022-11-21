package com.example.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Dao.UserContact;
import com.example.model.Dao.UserDetails;
import com.example.model.Dao.UserMaster;
import com.example.model.Dto.UserRequest;
import com.example.repository.UserMasterRepository;
import com.example.service.UserMasterService;

@Service
public class UserMasterServceImpl implements  UserMasterService{

	@Autowired
	UserMasterRepository userMasterRepository;
	
	@Override
	public void saveUser(UserRequest userRequest) {
	
		UserMaster userMaster =new UserMaster();
		UserDetails userDetails = new UserDetails();
		UserContact userContact = new UserContact();
		
		userMaster.setCreatedDate(new Date());
		userMaster.setPassword(userRequest.getPassword());
		userMaster.setStatus(true);
		userMaster.setPasswordExpireOn(new Date());
		userMaster.setLastLogin(new Date());
		
		userDetails.setEmail(userRequest.getEmail());
		userDetails.setContactNumber(userRequest.getContactNumber());
		userDetails.setDOB(userRequest.getDOB());
		userDetails.setLastName(userRequest.getLastName());
		userDetails.setName(userRequest.getFirstName());
		userMaster.setUserDetails(userDetails);
		userDetails.setMaster(userMaster);
		
		userContact.setAddress(userRequest.getAddress());
		userContact.setCity(userRequest.getCity());
		userContact.setPinCode(userRequest.getPinCode());
		userContact.setState(userRequest.getState());
		userContact.setMaster(userMaster);
		userMaster.addContact(userContact);
		
		userMasterRepository.save(userMaster);
	
	}

	
	
}
