package com.college.managment.college.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Teacher {

	@Id
	private long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private final String role ="TEACHER";
	
	private String subject;
	
	private String department;
	
	private String marriageStatus;
	
	private String spouseOrHusbandName;
	
	private String reposibility;
	
	private double salary;
	
	private String joiningDate;
	
	private String lastWorkingDate;
	
	private Boolean workingStatus;
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getLastWorkingDate() {
		return lastWorkingDate;
	}

	public void setLastWorkingDate(String lastWorkingDate) {
		this.lastWorkingDate = lastWorkingDate;
	}

	public Boolean getWorkingStatus() {
		return workingStatus;
	}

	public void setWorkingStatus(Boolean workingStatus) {
		this.workingStatus = workingStatus;
	}
	private List<String> listBatches;
	
	public String getReposibility() {
		return reposibility;
	}

	public void setReposibility(String reposibility) {
		this.reposibility = reposibility;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public List<String> getListBatches() {
		return listBatches;
	}

	public void setListBatches(List<String> listBatches) {
		this.listBatches = listBatches;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
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
	public Teacher() {
		
	}
	
}
