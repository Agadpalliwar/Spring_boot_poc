package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dao.UserDetails;
import com.example.demo.model.Dao.UserMaster;
import com.example.demo.model.Dto.UserRequest;
import com.example.demo.repository.UserDetailsRepository;
import com.example.demo.repository.UserMasterRepository;
import com.example.demo.service.UserMasterService;

@RestController 
public class UserDetailsController {

	@Autowired
	private UserMasterRepository userMasterRepo;
	
	@Autowired
	private UserMasterService userMasterService; 
	
	@Autowired
	UserDetailsRepository userDetailRepository;
	
		@GetMapping("/getUsersList")
		public List<UserMaster> getUserList() {
			return  userMasterRepo.findAll();

		}
		
		
	/*	@GetMapping("/getUser")
		public UserMaster getUserById(@RequestBody("id") Long id) {
		return userMasterRepo.findById(id).get();

		}*/
		
		
		
		@PostMapping("/save")
		public ResponseEntity<String> saveUser(@RequestBody UserRequest userRequest) {
			userMasterService.saveUser(userRequest);
			return new ResponseEntity<>("User Added", HttpStatus.OK);
		}
		
		@GetMapping("/test")
		public ResponseEntity<String> test1() {
			System.out.println("testing");
			 return new ResponseEntity<>("test", HttpStatus.OK);
		}
		
		@GetMapping("/getuserDetails/{id}")
		public String GetUserDetails(@PathVariable(value= "id") long id,Model model) {
			//get  employee data from the database
			UserRequest userRequest = UserMasterService.getUserDetailsById(id);
			// set employee as a model atribute to pre- populate the data
			model.addAttribute("userRequest",userRequest);
			
		return "userDetailsFound"; }
		
		@GetMapping("/findByEmail/{email}")
		public ResponseEntity<List<UserRequest>> findUserByEmail (@PathVariable("email") String email) {
			List<UserRequest> userDetails = new ArrayList<UserRequest>();
			UserMasterService.findByEmail(email).getClass();
			
			if(userDetails.isEmpty()) {
				 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			 return new ResponseEntity<>(userDetails, HttpStatus.OK);
		}
		
		
		@GetMapping("/findById/{id}")
		public ResponseEntity<UserMaster> findUserById (@PathVariable("id") Long id) {
			UserMaster details =  userMasterRepo.findById(id).get();
			
			if(details == null) {
				 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			 return new ResponseEntity<>(details, HttpStatus.OK);
			 
		}
		
		/*@GetMapping("/findByFirstName/{firstName}")
		public ResponseEntity<List<UserMaster>> findUserByFirstName (@PathVariable("firstName") String firstName) {
			List<UserMaster> userDetails = new ArrayList<UserMaster>();
			userDetailRepository.findUserByFirstName(firstName).forEach(userDetails::add);
			
			if(userDetails.isEmpty()) {
				 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			 return new ResponseEntity<>(userDetails, HttpStatus.OK);
		}*/
		
}
