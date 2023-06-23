package com.college.managment.college.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.managment.college.DTO.AdminDTO;
import com.college.managment.college.Entity.Admin;
import com.college.managment.college.Repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdminDTO fetchAdminByEmailId(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAdminById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAndUpdateAdminDetails(Admin admin) {
		// TODO Auto-generated method stub
		
	}

}
