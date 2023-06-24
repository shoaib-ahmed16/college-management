package com.college.managment.college.Services;

import com.college.managment.college.DTO.AdminDTO;
import com.college.managment.college.Entity.Admin;

public interface AdminService {
	
	public AdminDTO fetchByEmailId(String email);
	
	public String deleteById(Long id);
	
	public AdminDTO fetchById(Long id);
	
	public String saveAndUpdate(Admin admin);
}






