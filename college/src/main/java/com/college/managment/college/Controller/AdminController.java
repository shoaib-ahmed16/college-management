package com.college.managment.college.Controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.managment.college.DTO.AdminDTO;
import com.college.managment.college.Entity.Admin;
import com.college.managment.college.Exceptions.AdminNullPointerException;
import com.college.managment.college.Services.AdminService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/fetchById/{adminId}")
	public ResponseEntity<AdminDTO> getAdminById(@PathVariable("adminId") Long adminId){
		if(adminId!=null)
		 return new  ResponseEntity<AdminDTO>(adminService.fetchById(adminId),HttpStatus.OK);
		logger.error("Getting AdminId as null value");
		throw new AdminNullPointerException("Getting AdminId as null value");
	}
	
	@GetMapping("/fetchByEmail")
	public ResponseEntity<AdminDTO> getAdminByEmail(@RequestBody Map<String,String> params){
		if(params.get("email")!=null) {
		 return new ResponseEntity<AdminDTO>(adminService.fetchByEmailId(String.valueOf(params.get("email"))),HttpStatus.OK);
		}
		logger.error("Getting Admin Email Id as null value");
		throw new AdminNullPointerException("Getting Admin Email Id as null value");
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveAdmin(@RequestBody Admin admin){
		if(admin!=null)
			return new ResponseEntity<String>(adminService.saveAdmin(admin),HttpStatus.ACCEPTED);
		logger.error("Getting Admin Object as null value");
		throw new AdminNullPointerException("Getting Admin Object as null value");

	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateAdmin(@RequestBody Admin admin){
		if(admin !=null &&admin.getId()!=null )
			return new ResponseEntity<String>(adminService.updateAdmin(admin),HttpStatus.ACCEPTED);
		logger.error("Getting Admin Object without Admin Id Or null value");
		throw new AdminNullPointerException("Getting Admin Object without Admin Id or null value");
	}
	
	@DeleteMapping("/deleteById/{adminId}")
	public ResponseEntity<String> deleteAdminRecordById(@PathVariable("adminId") Long adminId) {
		if(adminId!=null)
			return new ResponseEntity<String>(adminService.deleteById(adminId),HttpStatus.ACCEPTED);
		logger.error("Getting Admin Id null value");
		throw new AdminNullPointerException("Getting Admin Id null value");
	
	}
	
	
	
}
