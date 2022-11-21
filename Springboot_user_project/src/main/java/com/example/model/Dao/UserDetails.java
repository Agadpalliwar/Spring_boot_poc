package com.example.model.Dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity(name = "user_details" )
public class UserDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	private String name;
	
	private String lastName;
	
	private String email;
	
	private String contactNumber;
	
	private Date DOB;
	
	@OneToOne
	private UserMaster master;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date Date) {
		DOB = Date;
	}

	public UserMaster getMaster() {
		return master;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", DOB=" + DOB + ", master=" + master + "]";
	}

	public void setMaster(UserMaster master) {
		this.master = master;
	}

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setDOB(String city) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
