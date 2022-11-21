package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Dao.UserDetails;
import com.example.model.Dao.UserMaster;
import com.example.model.Dto.UserRequest;
import com.example.repository.UserMasterRepository;
import com.example.service.UserDetailService;
import com.example.service.UserMasterService;
import com.example.service.impl.UserMasterServceImpl;

@RestController 
@RequestMapping("/user")
public class UserDetailsController {

	@Autowired
	private UserMasterRepository userMasterRepo;
	
	@Autowired
	private UserMasterService userMasterService; 
	
		@GetMapping("/getUsersList")
		public List<UserMaster> getUserList() {
			return  userMasterRepo.findAll();

		}
		@GetMapping("/showUserRegistrationForm")
		public String addUserDetails(Model model) {
			//create the model Attribute to add form data
			UserDetails userDetails = new UserDetails();
			model.addAttribute("userDetails", userDetails);
			return "new_employee";
		}
		
		@GetMapping("/getUser")
		public UserMaster getUserById(@RequestParam("id") Long id) {
		return userMasterRepo.findById(id).get();

		}
		
		@PostMapping("/save")
		public void saveUser(@RequestBody UserRequest userRequest) {
			userMasterService.saveUser(userRequest);
		}
		
		@GetMapping("/test")
		public String test() {
			return "testing";
		}
		
		
		
		
}
