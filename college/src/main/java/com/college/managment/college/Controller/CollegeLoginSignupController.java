package com.college.managment.college.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/collegeLoginContolCenter")
public class CollegeLoginSignupController {
	
	private static final Logger logger = LoggerFactory.getLogger(CollegeLoginSignupController.class);
	
//	@Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private TokenProvider jwtTokenUtil;
//
//    @Autowired
//    private AdminService adminService;


//    @RequestMapping(value="/admin", method = RequestMethod.POST)
//    public ResponseEntity<String> saveAdmin(@RequestBody Admin admin){
//		if(admin!=null)
//			return new ResponseEntity<String>(adminService.saveAdmin(admin),HttpStatus.ACCEPTED);
//		logger.error("Getting Admin Object as null value");
//		throw new AdminNullPointerException("Getting Admin Object as null value");
//	}

}
