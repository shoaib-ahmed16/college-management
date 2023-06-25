package com.college.managment.college.Services;

import java.util.List;
import java.util.Map;

import com.college.managment.college.DTO.LoginUser;
import com.college.managment.college.DTO.StudentDTO;
import com.college.managment.college.DTO.UserPasswordUpdateDTO;
import com.college.managment.college.Entity.Student;


public interface StudentService {

	public String passwordUpdate(UserPasswordUpdateDTO passwordUpdate);
	
    public String saveStudents(List<Student> students);
	
	public StudentDTO fetchStudentByEmail(String email);
	
	public List<StudentDTO> fetchStudentByNameAndBatchAndDepartment(Map<String,String> map);
	
	public String deleteStudentById(Long id);
	
	public String saveStudent(Student student);
	
	public String updateStudent(Student student);
	
	public List<StudentDTO> getAllStudent();
	
	public StudentDTO fetchStudentByID(Long id);
}
