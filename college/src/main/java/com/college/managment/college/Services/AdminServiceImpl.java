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
	public String saveAndUpdate(Admin admin) {
		String message ="Error Occured while shaving the Admin Record!";
		logger.info("Inside Admin Service class to save or update the Admin object: ",admin.getClass().getName());
		if(admin.getId()!=null) {
				logger.info("Start fetching the Object if Admin Id already Exist in the database Record");
				Optional<Admin> fetchAdmin =adminRepository.findById(admin.getId());
				if(fetchAdmin.isPresent()) {
					logger.info("Get the Admin Object which is already Exist in the database Record for the provided Id");
					logger.info("Start Updating the changed field for the Existing Admin Object");
						Admin adminToUpdate=fetchAdmin.get();
						adminToUpdate.setEmail(admin.getEmail());
						adminToUpdate.setMarriageStatus(admin.getMarriageStatus());
						adminToUpdate.setName(admin.getName());
						adminToUpdate.setRole(admin.getRole());
						adminRepository.save(adminToUpdate);
						logger.info("Admin Object details updated Successfully!");
					return "Admin Record save successfully!";
				}else {
					logger.info("Start saving the Admin Object");
					adminRepository.save(admin);
					logger.info("Admin Object saved Successfully!");
					return "Admin Record save successfully!";
				}
		}else {
			logger.info("Start saving the Admin Object");
			adminRepository.save(admin);
			logger.info("Admin Object saved Successfully!");
			return "Admin Record save successfully!";
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
	
}
