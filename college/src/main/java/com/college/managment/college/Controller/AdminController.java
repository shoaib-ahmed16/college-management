package com.college.managment.college.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.managment.college.DTO.StudentDTO;
import com.college.managment.college.Entity.Student;
import com.college.managment.college.Services.AdminService;
import com.college.managment.college.Services.StudentService;
import com.college.managment.college.Services.TeacherService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	
}
