package com.college.managment.college.Controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.college.managment.college.Config.TokenProvider;
import com.college.managment.college.DTO.AuthToken;
import com.college.managment.college.DTO.LoginUser;
import com.college.managment.college.Entity.Admin;
import com.college.managment.college.Exceptions.AdminNullPointerException;
import com.college.managment.college.Services.AdminService;
import com.college.managment.college.Services.UserLoginServer;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/collegeLoginContolCenter")
public class CollegeLoginSignupController {
	
	private static final Logger logger = LoggerFactory.getLogger(CollegeLoginSignupController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserLoginServer userService;
    
    @Autowired
    private AdminService adminService;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser, HttpServletRequest req) throws AuthenticationException {

    	final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value="/admin", method = RequestMethod.POST)
    public ResponseEntity<String> saveAdmin(@RequestBody Admin admin){
		if(admin!=null)
			return new ResponseEntity<String>(adminService.saveAdmin(admin),HttpStatus.ACCEPTED);
		logger.error("Getting Admin Object as null value");
		throw new AdminNullPointerException("Getting Admin Object as null value");
	}

}
