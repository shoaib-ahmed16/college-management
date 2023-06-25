package com.college.managment.college.Services;

import com.college.managment.college.DTO.AdminDTO;
import com.college.managment.college.DTO.LoginUser;
import com.college.managment.college.DTO.UserPasswordUpdateDTO;
import com.college.managment.college.Entity.Admin;

public interface AdminService {
	
	public String passwordUpdate(UserPasswordUpdateDTO passwordUpdate);
	
	public AdminDTO fetchByEmailId(String email);
	
	public String deleteById(Long id);
	
	public AdminDTO fetchById(Long id);
	
	public String saveAdmin(Admin admin);
	
	public String updateAdmin(Admin admin);
	
}






