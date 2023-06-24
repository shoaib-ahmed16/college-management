package com.college.managment.college.Services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.managment.college.DTO.AdminDTO;
import com.college.managment.college.Entity.Admin;
import com.college.managment.college.Exceptions.AdminDoesNotExistException;
import com.college.managment.college.Exceptions.AdminUnknownServerError;
import com.college.managment.college.Repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public AdminDTO fetchById(Long id) {
		logger.info("Start Fetching details for Admin using Admin Id: ",id);
			Optional<Admin> admin =adminRepository.findById(id);
		if(admin.isPresent()) {
			logger.info("Get detail for an Admin using admin Id: ",id);
			return new AdminDTO(admin.get()) ;
		}else{
			 logger.error("Admin Doesnot Exist for the Id:"+id);
			 throw new AdminDoesNotExistException("Admin Doesnot Exist for the Id:"+id);
		}
	}
	

	@Override
	public AdminDTO fetchByEmailId(String email) {
		logger.info("Start Fetching the Admin details using the emailId: "+email);
		Optional<Admin> admin =adminRepository.findByEmail(email);
		if(admin.isPresent()) {
			logger.info("Get the Admin details for the emailId: "+email);
			return new AdminDTO(admin.get());
		}else {
			logger.error("Fail to fetch the Admin details for the emailId: "+email);
			logger.debug("Fail to fetch the Admin details for the emailId: "+email);
			throw new AdminDoesNotExistException("Admin Details for the Admin Email id: "+email+"Doesnot exist int the Records");
		}
	}

	@Override
	public String deleteById(Long id) {
		String message="Fail to fetch the admin details Using the Admin Id: "+id;
		logger.info("Start Fetching Admin details for the Admin Id: "+id);
		Optional<Admin> admin =adminRepository.findById(id);
		if(admin.isPresent()) {
			logger.info("Get Admin details for the Admin Id: "+id+" To delete the Record");
			adminRepository.delete(admin.get());
			logger.warn("Admin details for the Admin Id: "+id+" deleted Successfully!");
			return "Admin Record deleted Successfully";
		}else
			logger.error("No Record found for Admin using adminID: "+id);
			throw new AdminDoesNotExistException("Delete Operation not successful as no Admin Reocord found! for the Admin Id: "+id);
	}

	@Override
	public String saveAdmin(Admin admin) {
		try {
			logger.info("Start saving the Admin details into records");
			adminRepository.save(admin);
			logger.info("Admin details saved Successfully!");
			return "Admin details save successfully!";
		}catch(Exception exc) {
			logger.error("Unknown server error occured while saving Admin details to the records");
			throw new AdminUnknownServerError("Unknown server error occured while saving Admin details to the records");
		}
	}

	@Override
	public String updateAdmin(Admin admin) {
		logger.info("Start fetching the Admin Record using Admin Id: "+admin.getId());
		Optional<Admin> fetchAdmin =adminRepository.findById(admin.getId());
		if(fetchAdmin.isPresent()) {
			logger.info("Get the Admin record for the Admin Id: "+admin.getId());
			logger.info("Start Updating the changed field for the Existing Admin record");
				Admin adminToUpdate=fetchAdmin.get();
				adminToUpdate.setEmail(admin.getEmail());
				adminToUpdate.setMarriageStatus(admin.getMarriageStatus());
				adminToUpdate.setName(admin.getName());
				adminToUpdate.setRole(admin.getRole());
				logger.warn("Start updating Admin Record details!");
				adminRepository.save(adminToUpdate);
				logger.info("Admin Record details updated Successfully!");
			return "Admin Record updated successfully!";
		}
		logger.error("No Admin Record found for the Admin Id: "+admin.getId());
		throw new AdminDoesNotExistException("No Admin Record found for the Admin Id: "+admin.getId());
	}
	
}
