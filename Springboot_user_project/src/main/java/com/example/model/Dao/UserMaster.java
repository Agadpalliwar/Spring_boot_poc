package com.example.model.Dao;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "user_master")
public class UserMaster {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
    @Column(name = "userName")
    private String userName;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "lastLogin")
    private Date lastLogin= new Date() ;
    
    @Column(name = "passwordExpireOn")
    private Date passwordExpireOn = new Date();
    
    @Column(name = "createdDate")
    private Date createdDate = new Date();
    
    private boolean status =true;
    
   @OneToMany(cascade = CascadeType.ALL,mappedBy = "master") 
   private Set<UserContact> userContact;
    
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "master")
    private UserDetails userDetails;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getPasswordExpireOn() {
		return passwordExpireOn;
	}

	public void setPasswordExpireOn(Date passwordExpireOn) {
		this.passwordExpireOn = passwordExpireOn;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<UserContact> getUserContact() {
		return userContact;
	}

	public void setUserContact(Set<UserContact> userContact) {
		this.userContact = userContact;
	}

	public void addContact(UserContact userContact) {
		this.userContact.add(userContact);
	}

	
	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public UserMaster() {
		super();
	}
    
    
}
