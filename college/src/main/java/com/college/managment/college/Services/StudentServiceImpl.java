package com.college.managment.college.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.managment.college.DTO.StudentDTO;
import com.college.managment.college.Entity.Student;
import com.college.managment.college.Repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService{

	@Autowired 
	private StudentRepository studentRepo;
	
	@Override
	public void saveStudents(List<Student> students) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StudentDTO fetchStudentByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO fetchStudentByNameAndBatchAndDepartment(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveAndUpdateStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepo.save(student);
		return "Save"; 
	}

	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentDTO> getAllStudent() {
		List<StudentDTO> list= new ArrayList<>();
		List<Student> findALl =studentRepo.findAll();
		for(Student s:findALl) {
			list.add(new StudentDTO(s));
		}
		return list;
	}

}
