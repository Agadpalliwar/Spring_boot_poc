package com.example.demo.securityService;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.Dao.UserMaster;

public class CustomUserDetailsServiceImpl implements UserDetails {
	
    private UserMaster userMaster;
	
	public CustomUserDetailsServiceImpl(UserMaster userMaster) {
		super();
		this.userMaster = userMaster;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(userMaster.getRole()));
	}

	@Override
	public String getPassword() {
		return userMaster.getPassword();
	}

	@Override
	public String getUsername() {
		return userMaster.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
