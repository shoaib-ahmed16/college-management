package com.college.managment.college.Controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.college.managment.college.Config.TokenProvider;
import com.college.managment.college.DTO.AdminDTO;
import com.college.managment.college.Entity.Admin;
import com.college.managment.college.Exceptions.AdminNullPointerException;
import com.college.managment.college.Services.AdminService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;
	
	@Autowired
	private AdminService adminService;
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/fetchById/{adminId}")
	public ResponseEntity<AdminDTO> getAdminById(@PathVariable("adminId") Long adminId){
		if(adminId!=null)
		 return new  ResponseEntity<AdminDTO>(adminService.fetchById(adminId),HttpStatus.OK);
		logger.error("Getting AdminId as null value");
		throw new AdminNullPointerException("Getting AdminId as null value");
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/fetchByEmail")
	public ResponseEntity<AdminDTO> getAdminByEmail(@RequestBody Map<String,String> params){
		if(params.get("email")!=null) {
		 return new ResponseEntity<AdminDTO>(adminService.fetchByEmailId(String.valueOf(params.get("email"))),HttpStatus.OK);
		}
		logger.error("Getting Admin Email Id as null value");
		throw new AdminNullPointerException("Getting Admin Email Id as null value");
	}

	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/update")
	public ResponseEntity<String> updateAdmin(@RequestBody Admin admin){
		if(admin !=null &&admin.getId()!=null )
			return new ResponseEntity<String>(adminService.updateAdmin(admin),HttpStatus.ACCEPTED);
		logger.error("Getting Admin Object without Admin Id Or null value");
		throw new AdminNullPointerException("Getting Admin Object without Admin Id or null value");
	}
	
	 @RequestMapping(value="/admin", method = RequestMethod.POST)
	    public ResponseEntity<String> saveAdmin(@RequestBody Admin admin){
			if(admin!=null)
				return new ResponseEntity<String>(adminService.saveAdmin(admin),HttpStatus.ACCEPTED);
			logger.error("Getting Admin Object as null value");
			throw new AdminNullPointerException("Getting Admin Object as null value");
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/deleteById/{adminId}")
	public ResponseEntity<String> deleteAdminRecordById(@PathVariable("adminId") Long adminId) {
		if(adminId!=null)
			return new ResponseEntity<String>(adminService.deleteById(adminId),HttpStatus.ACCEPTED);
		logger.error("Getting Admin Id null value");
		throw new AdminNullPointerException("Getting Admin Id null value");
	
	}
	
	
	
}
