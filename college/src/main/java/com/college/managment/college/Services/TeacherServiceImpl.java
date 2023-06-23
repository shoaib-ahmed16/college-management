package com.college.managment.college.Services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.college.managment.college.DTO.TeacherDTO;
import com.college.managment.college.Entity.Teacher;


@Service
public class TeacherServiceImpl implements TeacherService {

	@Override
	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TeacherDTO fetchTeacherByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherDTO fetchTeacherByNameAndDepartmentAndSubject(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTeacherById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAndUpdateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

}
