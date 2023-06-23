package com.college.managment.college.Services;

import java.util.List;
import java.util.Map;

import com.college.managment.college.DTO.StudentDTO;
import com.college.managment.college.Entity.Student;


public interface StudentService {

    public void saveStudents(List<Student> students);
	
	public StudentDTO fetchStudentByEmail(String email);
	
	public StudentDTO fetchStudentByNameAndBatchAndDepartment(Map<String,String> map);
	
	public void deleteStudentById(Long id);
	
	public String saveAndUpdateStudent(Student student);
	
	public List<StudentDTO> getAllStudent();
}
