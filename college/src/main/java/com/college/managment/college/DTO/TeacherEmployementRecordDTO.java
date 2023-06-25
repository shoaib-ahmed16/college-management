package com.college.managment.college.DTO;

import com.college.managment.college.Entity.Teacher;

public class TeacherEmployementRecordDTO {

	private String email;
	
	private Long id;
	
    private Double salary;
	
	private String joiningDate;
	
	private String lastWorkingDate;
	
	private Boolean workingStatus;
	
	private String reposibility;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getReposibility() {
		return reposibility;
	}

	public void setReposibility(String reposibility) {
		this.reposibility = reposibility;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getSalary() {
		return salary;
	}

	public TeacherEmployementRecordDTO() {
		
	}
	
	public TeacherEmployementRecordDTO(Teacher teacher) {
		this.id=teacher.getId();
		this.joiningDate=teacher.getJoiningDate();
		this.lastWorkingDate=teacher.getLastWorkingDate();
		this.reposibility=teacher.getReposibility();
		this.salary=teacher.getSalary();
		this.workingStatus=teacher.getWorkingStatus();
		this.email=teacher.getEmail();
	}
}
