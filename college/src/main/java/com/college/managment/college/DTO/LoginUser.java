package com.college.managment.college.DTO;

import java.util.Set;

import com.college.managment.college.Entity.Admin;
import com.college.managment.college.Entity.Student;
import com.college.managment.college.Entity.Teacher;

public class LoginUser {
	private String username;
    private String password;
    private Set<String> roles;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public LoginUser(Teacher teacher) {
    	this.password=teacher.getPassword();
    	this.username=teacher.getEmail();
    	this.roles=teacher.getRole();
    }
    public LoginUser(Admin admin) {
    	this.username=admin.getEmail();
    	this.password=admin.getPassword();
    	this.roles=admin.getRole();
    }
	public LoginUser(Student student) {
	    this.username=student.getEmail();
	    this.password=student.getPassword();
	    this.roles=student.getRole();
	}
	public LoginUser() {
		
	}
}
