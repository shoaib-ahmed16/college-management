package com.college.managment.college.DTO;

import java.util.Map;
import java.util.Set;

import com.college.managment.college.Entity.Student;

public class StudentDTO {

	private long id;
	
	private String name;
	
	private String email;
	
	private Set<String> role;
	
	private String batch;
	
	private String department;
	
	private String dateOfBirth;
	
	private String fatherName;
	
	private String motherName;
	
	private Map<String,String> subjects;

	
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

	public Map<String, String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Map<String, String> subjects) {
		this.subjects = subjects;
	}
	
	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public StudentDTO() {
		
	}
	public StudentDTO(Student student) {
		this.id=student.getId();
		this.email=student.getEmail();
		this.dateOfBirth=student.getDateOfBirth();
		this.department=student.getDepartment();
		this.fatherName=student.getFatherName();
		this.motherName=student.getMotherName();
		this.name=student.getName();
		this.role=student.getRole();
		this.subjects=student.getSubjects();
		this.batch=student.getBatch();
	}
	
	
}
