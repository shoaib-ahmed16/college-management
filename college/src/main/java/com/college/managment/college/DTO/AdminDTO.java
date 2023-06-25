package com.college.managment.college.DTO;

import java.util.Set;

import com.college.managment.college.Entity.Admin;

public class AdminDTO {

    private long id;
	
	private String name;
	
	private String email;
	
    private String marriageStatus;
    
    private String spouseOrHusbandName;
	
	private Set<String> role;

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
	
	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public AdminDTO() {
		
	}
    public AdminDTO(Admin admin) {
    	this.id = admin.getId();
    	this.name = admin.getName();
    	this.email = admin.getEmail();
    	this.marriageStatus = admin.getMarriageStatus();
    	this.spouseOrHusbandName = admin.getSpouseOrHusbandName();
    	this.role = admin.getRole();

	}
	
}
