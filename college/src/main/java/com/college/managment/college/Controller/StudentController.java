package com.college.managment.college.Controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.managment.college.DTO.StudentDTO;
import com.college.managment.college.Entity.Student;
import com.college.managment.college.Exceptions.StudentNullPointerException;
import com.college.managment.college.Services.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private TokenProvider jwtTokenUtil;
	
	@Autowired
	private StudentService studentService;
	
	//@PreAuthorize("hasRole('STUDENT')")
	@GetMapping("/fetchAll")
	public ResponseEntity<List<StudentDTO>> gettudent() {
		return new ResponseEntity<List<StudentDTO>>(studentService.getAllStudent(),HttpStatus.OK);
	}
	
	//@PreAuthorize("hasRole('STUDENT')")
	@GetMapping("/fetchBy/{studentId}")
	public ResponseEntity<StudentDTO> fetchStudentById(@PathVariable("studentId") Long studentId) throws StudentNullPointerException{
		if(studentId !=null)
		return new ResponseEntity<StudentDTO>(studentService.fetchStudentByID(studentId),HttpStatus.OK);
		logger.error("Getting studentId as null value");
		throw new StudentNullPointerException("Getting studentId as null value");
	
	}
	//@PreAuthorize("hasRole('STUDENT')")
	@GetMapping("/fetchByEmail")
	public ResponseEntity<StudentDTO> fetchStudentByEmail(@RequestBody Map<String,String> params)throws StudentNullPointerException {
		if(params.get("email")!=null) {
			return new ResponseEntity<StudentDTO>(studentService.fetchStudentByEmail(String.valueOf(params.get("email"))),HttpStatus.OK);
		}
		logger.error("Getting student emailId as null value");
		throw new StudentNullPointerException("Getting student emailId as null value");
	
	}
	
	//@PreAuthorize("hasRole('STUDENT')")
	@GetMapping("/fetchByNameBatchDepartment")
	public ResponseEntity<List<StudentDTO>> fetchByNameBatchDepartment(@RequestBody Map<String,String> params)throws StudentNullPointerException {
		if(params!=null) 
		return new ResponseEntity<List<StudentDTO>>(studentService.fetchStudentByNameAndBatchAndDepartment(params),HttpStatus.OK);
		logger.error("Getting student field map as null value");
		throw new StudentNullPointerException("Getting student field map as null value");
	
	}
	
	//@PreAuthorize("hasRole('TEACHER')")
	@DeleteMapping("/deleteBy/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Long studentId) throws StudentNullPointerException{
		if(studentId!=null)
			return new ResponseEntity<String>(studentService.deleteStudentById(studentId),HttpStatus.ACCEPTED);
		logger.error("Getting studentId as null value");
		throw new StudentNullPointerException("Getting studentId as null value");
	
	}
	//@PreAuthorize("hasRole('TEACHER')")
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student)throws StudentNullPointerException {
		if(student!=null) {
			return new ResponseEntity<String>(studentService.saveStudent(student),HttpStatus.ACCEPTED);
		}
		logger.error("Getting student as null value");
		throw new StudentNullPointerException("Getting student as null value");
	}
	
	//@PreAuthorize("hasRole('TEACHER')")
	@PostMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student student)throws StudentNullPointerException {
		if(student!=null && student.getId()!=null)
		 return new ResponseEntity<String>(studentService.updateStudent(student),HttpStatus.ACCEPTED);
		logger.error("Getting student or studentId as null value");
		throw new StudentNullPointerException("Getting student or studentId  as null value");
	}
}
