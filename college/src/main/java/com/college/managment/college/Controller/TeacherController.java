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

import com.college.managment.college.DTO.TeacherDTO;
import com.college.managment.college.DTO.TeacherEmployementRecordDTO;
import com.college.managment.college.Entity.Teacher;
import com.college.managment.college.Services.StudentService;
import com.college.managment.college.Services.TeacherService;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
	
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
		else 
			throw new RuntimeException("Email Value cannot Be null");
	}
	
	@GetMapping("/fetchByNameAndDepartmentAndSubject")
	public List<TeacherDTO> getTeacherByNameAndDepartmentAndSubject(@RequestBody Map<String,String> map) {
		return teacherService.fetchTeacherByNameAndDepartmentAndSubject(map);
	}
	@GetMapping("/fetchEmployeementRecordByEmailIdOrId")
	public TeacherEmployementRecordDTO getTeacherEmployeementRecordByEmaild(@RequestBody Map<String,String> params) {
		String email =null;
		Long id = null;
		if(params.get("email")!=null) {
			email=String.valueOf(params.get("email"));
		}
		if(params.get("id")!=null) {
			id=Long.parseLong(params.get("id"));
		}
		return teacherService.getTeacherEmployeementRecordByEmailId(email, id);
	}
	
	@GetMapping("/fetchAllEmployeementRecords")
	public List<TeacherEmployementRecordDTO> getAllTeacherEmployeementRecord() {
		return teacherService.getTeachersEmployeementRecords();
	}
	
	@PostMapping("/save")
	public String saveTeacher(@RequestBody Teacher teacher) {
		return teacherService.saveAndUpdateTeacher(teacher);
	}
	
	@PostMapping("/update")
	public String updateTeacher(@RequestBody Teacher teacher) {
		return teacherService.saveAndUpdateTeacher(teacher);
	}
	
	@DeleteMapping("/deleteBy/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		return teacherService.deleteTeacherById(id);
	}
	
}
