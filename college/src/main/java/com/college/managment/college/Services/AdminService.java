package com.college.managment.college.Services;

import com.college.managment.college.DTO.AdminDTO;
import com.college.managment.college.Entity.Admin;

public interface AdminService {

	public void saveAdmin(Admin admin);
	
	public AdminDTO fetchAdminByEmailId(String email);
	
	public void deleteAdminById(Long id);
	
	public void saveAndUpdateAdminDetails(Admin admin);
}
