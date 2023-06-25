package com.college.managment.college.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.college.managment.college.DTO.LoginUser;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/collegeLoginContolCenter")
public class CollegeLoginSignupController {
	
	private static final Logger logger = LoggerFactory.getLogger(CollegeLoginSignupController.class);
	
	@Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private TokenProvider jwtTokenUtil;
//
//    @Autowired
//    private AdminService adminService;
//
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser, HttpServletRequest req) throws AuthenticationException {

    try {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContext sc =SecurityContextHolder.getContext();
        sc.setAuthentication(authentication);
        
        HttpSession session = req.getSession(true);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, session);
        return new ResponseEntity<String>( "Authentication Successfull",HttpStatus.ACCEPTED);
    }catch(Exception exc) {
    	return new ResponseEntity<String>( "Authentication fail",HttpStatus.FORBIDDEN);
    }
//        final String token = jwtTokenUtil.generateToken(authentication);
//        return ResponseEntity.ok(new AuthToken(token));
    }

//    @RequestMapping(value="/admin", method = RequestMethod.POST)
//    public ResponseEntity<String> saveAdmin(@RequestBody Admin admin){
//		if(admin!=null)
//			return new ResponseEntity<String>(adminService.saveAdmin(admin),HttpStatus.ACCEPTED);
//		logger.error("Getting Admin Object as null value");
//		throw new AdminNullPointerException("Getting Admin Object as null value");
//	}

}
