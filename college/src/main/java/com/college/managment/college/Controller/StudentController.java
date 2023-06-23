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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.managment.college.DTO.StudentDTO;
import com.college.managment.college.Entity.Student;
import com.college.managment.college.Services.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public String saveStudent(@RequestBody Student student) {
		return studentService.saveAndUpdateStudent(student);
	}
	
	@GetMapping("/fetchAll")
	public List<StudentDTO> gettudent() {
		return studentService.getAllStudent();
	}
	
	@GetMapping("/fetchBy/{id}")
	public StudentDTO fetchStudentById(@PathVariable("id") Long id) {
		return studentService.fetchStudentByID(id);
	}
	@GetMapping("/fetchByEmail")
	public StudentDTO fetchStudentByEmail(@RequestBody Map<String,String> map) {
		try {
			if(map.get("email")!=null) {
				return studentService.fetchStudentByEmail(String.valueOf(map.get("email")));
			}else
				throw new Exception("Email cannot be null");
		}catch(Exception exc) {
			
		}
		throw new RuntimeException("Email cannnot be null");
	}
	@GetMapping("/fetchByNameBatchDepartment")
	public List<StudentDTO> fetchByNameBatchDepartment(@RequestBody Map<String,String> map) {
		return studentService.fetchStudentByNameAndBatchAndDepartment(map);
	}
	
	@DeleteMapping("/deleteBy/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		return studentService.deleteStudentById(id);
	}
	@PostMapping("/update")
	public String updateStudent(@RequestBody Student student) {
		return studentService.saveAndUpdateStudent(student);
	}
}
