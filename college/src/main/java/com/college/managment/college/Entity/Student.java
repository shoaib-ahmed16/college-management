package com.college.managment.college.Entity;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="student")
public class Student {

	@Id
	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String role ="STUDENT";
	
	private String batch;
	
	private String department;
	
	private String dateOfBirth;
	
	private String fatherName;
	
	private String motherName;
	
	private Map<String,String>  subjects;

	public String getName() {
		return name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getRole() {
		return role;
	}

	public Map<String, String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Map<String, String> subjects) {
		this.subjects = subjects;
	}

	public Student() {
		
	}

}
