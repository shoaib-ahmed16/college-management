package com.college.managment.college.Entity;

import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Student {

	@Id
	private ObjectId id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String role ="STUDENT";
	
	private String batch;
	
	private String department;
	
	private String dateOfBirth;
	
	private String fatherName;
	
	private String motherName;
	
	private Map<String,Integer> subjects;

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Map<String, Integer> getSubjects() {
		return subjects;
	}

	public void setSubjects(Map<String, Integer> subjects) {
		this.subjects = subjects;
	}

	public String getRole() {
		return role;
	}
	
	public Student() {
		
	}
}
