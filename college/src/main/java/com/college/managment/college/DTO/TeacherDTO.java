package com.college.managment.college.DTO;

import java.util.List;

import com.college.managment.college.Entity.Teacher;

public class TeacherDTO {

    private long id;
	
	private String name;
	
	private String email;
	
	private String role;
	
	private String subject;
	
	private String department;
	
	private String marriageStatus;
	
	private String spouseOrHusbandName;
	
	private String reposibility;
	
	private List<String> listBatches;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public String getReposibility() {
		return reposibility;
	}

	public void setReposibility(String reposibility) {
		this.reposibility = reposibility;
	}

	public List<String> getListBatches() {
		return listBatches;
	}

	public void setListBatches(List<String> listBatches) {
		this.listBatches = listBatches;
	}
	
	public TeacherDTO(Teacher teacher) {
		this.department=teacher.getDepartment();
		this.email=teacher.getEmail();
		this.id=teacher.getId();
		this.listBatches=teacher.getListBatches();
		this.marriageStatus=teacher.getMarriageStatus();
		this.spouseOrHusbandName=teacher.getSpouseOrHusbandName();
		this.subject=teacher.getSubject();
		this.role=teacher.getRole();
		this.reposibility=this.getReposibility();
	}
}
