package com.college.managment.college.Controller;

import java.util.List;
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

import com.college.managment.college.DTO.TeacherDTO;
import com.college.managment.college.DTO.TeacherEmployementRecordDTO;
import com.college.managment.college.Entity.Teacher;
import com.college.managment.college.Exceptions.TeacherNullPointerException;
import com.college.managment.college.Services.TeacherService;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<TeacherDTO>> getAllTeacher() {
		return new ResponseEntity<List<TeacherDTO>>(teacherService.fetchAllTeacher(),HttpStatus.OK);
	}

	@GetMapping("/fetchById/{id}")
	public ResponseEntity<TeacherDTO> getTeacherByiId(@PathVariable("id") Long id) {
		return new ResponseEntity<TeacherDTO>(teacherService.fetchTeacherById(id),HttpStatus.OK);
	}
	
	@GetMapping("/fetchByEmail")
	public ResponseEntity<TeacherDTO> getTeacherByEmail(@RequestBody Map<String,String> params) {
		if(params.get("email")!=null)
		  return new ResponseEntity<TeacherDTO>(teacherService.fetchTeacherByEmail(String.valueOf(params.get("email"))),HttpStatus.OK);
		logger.error("Getting email Id empty or null value");
		throw new RuntimeException("Getting email Id empty or null value");
	}
	
	@GetMapping("/fetchByNameAndDepartmentAndSubject")
	public ResponseEntity<List<TeacherDTO>> getTeacherByNameAndDepartmentAndSubject(@RequestBody Map<String,String> params) {
		if(params!=null)
			return new ResponseEntity<List<TeacherDTO>>(teacherService.fetchTeacherByNameAndDepartmentAndSubject(params),HttpStatus.OK);
		logger.error("Get null value for the map: map cannot be null");
		throw new TeacherNullPointerException("Get null value for the map: map cannot be null");
	}
	@GetMapping("/fetchEmployeementRecordByEmailId")
	public ResponseEntity<TeacherEmployementRecordDTO> getTeacherEmployeementRecordByld(@RequestBody Map<String,String> params) {
		if(params.get("email")!=null) 
			return new ResponseEntity<TeacherEmployementRecordDTO>(teacherService.getTeacherEmployeementRecordByEmailId(String.valueOf(params.get("email"))),HttpStatus.OK);
		logger.error("Getting email Id empty or null value");
		throw new TeacherNullPointerException("Getting email Id empty or null value");
		
	}
	
	@GetMapping("/fetchEmployeementRecordById/{teacherId}")
	public ResponseEntity<TeacherEmployementRecordDTO> getTeacherEmployeementRecordByEmaild(@PathVariable("teacherId") Long teacherId) {
		if(teacherId!=null)
			return new  ResponseEntity<TeacherEmployementRecordDTO>(teacherService.getTeacherEmployeementRecordById(teacherId),HttpStatus.OK);
		logger.error("Getting Teacher Id empty or null value");
		throw new TeacherNullPointerException("Getting Teacher Id empty or null value");
	}
	
	@GetMapping("/fetchAllEmployeementRecords")
	public ResponseEntity<List<TeacherEmployementRecordDTO>> getAllTeacherEmployeementRecord() {
		return new ResponseEntity<List<TeacherEmployementRecordDTO>>(teacherService.getTeachersEmployeementRecords(),HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveTeacher(@RequestBody Teacher teacher) {
		if(teacher!=null)
			return new ResponseEntity<String>(teacherService.save(teacher),HttpStatus.ACCEPTED);
		logger.error("Getting Teacher Object as null value");
		throw new TeacherNullPointerException("Getting Teacher Object as null value");
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateTeacher(@RequestBody Teacher teacher) {
		if(teacher.getId()!=null)
			return new ResponseEntity<String>(teacherService.update(teacher),HttpStatus.ACCEPTED);
		logger.error("Getting Teacher Object without Teacher Id: Not a valid Object for this Api call");
		throw new TeacherNullPointerException("Getting Teacher Object without Teacher Id: Not a valid Object for this Api call");
	}
	
	@DeleteMapping("/deleteBy/{teacherId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("teacherId") Long teacherId) {
		if(teacherId!=null)
		   return new ResponseEntity<String>(teacherService.deleteTeacherById(teacherId),HttpStatus.ACCEPTED);
		logger.error("Getting teacher id as null value");
		throw new TeacherNullPointerException("Getting teacher id as null value");
	}
	
}
