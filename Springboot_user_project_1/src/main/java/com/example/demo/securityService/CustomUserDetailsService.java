package com.example.demo.securityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Dao.UserMaster;

import com.example.demo.repository.UserMasterRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserMasterRepository userMasterRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserMaster userMaster = (UserMaster) userMasterRepo.findByUserName(username);
		return  new CustomUserDetailsServiceImpl(userMaster);
	}
	
	
}
