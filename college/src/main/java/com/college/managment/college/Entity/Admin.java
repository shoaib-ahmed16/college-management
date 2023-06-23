package com.college.managment.college.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Admin {

	@Id
	private long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
    private String marriageStatus;
    
    private String spouseOrHusbandName;
	
	private final String role ="ADMIN";
	
	public String getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(String marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public String getSpouseOrHusbandName() {
		return spouseOrHusbandName;
	}

	public void setSpouseOrHusbandName(String spouseOrHusbandName) {
		this.spouseOrHusbandName = spouseOrHusbandName;
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}
	
	public Admin() {
		
	}
}
