package com.college.managment.college.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.managment.college.Services.StudentService;
import com.college.managment.college.Services.TeacherService;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	
}
