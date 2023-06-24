package com.college.managment.college.Controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.college.managment.college.Exceptions.TeacherUnknownServerError;
import com.college.managment.college.Services.StudentService;
import com.college.managment.college.Services.TeacherService;
import com.college.managment.college.Services.TeacherServiceImpl;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/fetchAll")
	public List<TeacherDTO> getAllTeacher() {
		return teacherService.fetchAllTeacher();
	}
	

	@GetMapping("/fetchById/{id}")
	public TeacherDTO getTeacherByiId(@PathVariable("id") Long id) {
		return teacherService.fetchTeacherById(id);
	}
	
	@GetMapping("/fetchByEmail")
	public TeacherDTO getTeacherByEmail(@RequestBody Map<String,String> params) {
		if(params.get("email")!=null)
		  return teacherService.fetchTeacherByEmail(String.valueOf(params.get("email")));
		
		logger.error("Getting email Id empty or null value");
		throw new RuntimeException("Getting email Id empty or null value");
	}
	
	@GetMapping("/fetchByNameAndDepartmentAndSubject")
	public List<TeacherDTO> getTeacherByNameAndDepartmentAndSubject(@RequestBody Map<String,String> params) {
		if(params!=null)
			return teacherService.fetchTeacherByNameAndDepartmentAndSubject(params);
		logger.error("Get null value for the map: map cannot be null");
		throw new TeacherNullPointerException("Get null value for the map: map cannot be null");
	}
	@GetMapping("/fetchEmployeementRecordById")
	public TeacherEmployementRecordDTO getTeacherEmployeementRecordByld(@RequestBody Map<String,String> params) {
		if(params.get("email")!=null) 
			return teacherService.getTeacherEmployeementRecordByEmailId(String.valueOf(params.get("email")));
		logger.error("Getting email Id empty or null value");
		throw new TeacherNullPointerException("Getting email Id empty or null value");
		
	}
	
	@GetMapping("/fetchEmployeementRecordByEmailId/{teacherId}")
	public TeacherEmployementRecordDTO getTeacherEmployeementRecordByEmaild(@PathVariable("teacherId") Long teacherId) {
		if(teacherId!=null)
			return teacherService.getTeacherEmployeementRecordById(teacherId);
		logger.error("Getting Teacher Id empty or null value");
		throw new TeacherNullPointerException("Getting Teacher Id empty or null value");
	}
	
	@GetMapping("/fetchAllEmployeementRecords")
	public List<TeacherEmployementRecordDTO> getAllTeacherEmployeementRecord() {
		return teacherService.getTeachersEmployeementRecords();
	}
	
	@PostMapping("/save")
	public String saveTeacher(@RequestBody Teacher teacher) {
		if(teacher!=null)
			return teacherService.save(teacher);
		logger.error("Getting Teacher Object as null value");
		throw new TeacherNullPointerException("Getting Teacher Object as null value");
	}
	
	@PostMapping("/update")
	public String updateTeacher(@RequestBody Teacher teacher) {
		if(teacher.getId()!=null)
			return teacherService.update(teacher);
		logger.error("Getting Teacher Object without Teacher Id: Not a valid Object for this Api call");
		throw new TeacherNullPointerException("Getting Teacher Object without Teacher Id: Not a valid Object for this Api call");
	}
	
	@DeleteMapping("/deleteBy/{teacherId}")
	public String deleteStudent(@PathVariable("teacherId") Long teacherId) {
		if(teacherId!=null)
		   return teacherService.deleteTeacherById(teacherId);
		logger.error("Getting teacher id as null value");
		throw new TeacherNullPointerException("Getting teacher id as null value");
	}
	
}
