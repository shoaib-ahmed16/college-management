package com.college.managment.college.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.managment.college.DTO.AdminDTO;
import com.college.managment.college.Entity.Admin;
import com.college.managment.college.Services.AdminService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/fetchAll")
	public List<AdminDTO> getAllAdmin(){
		return null;
	}
	
	@GetMapping("/fetchById/{adminId}")
	public AdminDTO getAdminById(@PathVariable("adminId") Long adminId){
		return adminService.fetchById(adminId);
	}
	
	@GetMapping("/fetchByEmail")
	public AdminDTO getAdminByEmail(@RequestBody Map<String,String> params){
		if(params.get("email")!=null) {
		 return adminService.fetchByEmailId(String.valueOf(params.get("email")));
		}
		throw new RuntimeException("Error");
	}
	
	@PostMapping("/saveAndUpdate")
	public String saveAndUpdateAdmin(@RequestBody Admin admin){
		return adminService.saveAndUpdate(admin);
	}
	
	@DeleteMapping("/deleteById/{adminId}")
	public String deleteAdminRecordById(@PathVariable("adminId") Long adminId) {
		return adminService.deleteById(adminId);
	}
	
	
	
}
