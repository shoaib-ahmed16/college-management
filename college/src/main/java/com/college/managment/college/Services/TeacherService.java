package com.college.managment.college.Services;

import java.util.Map;

import com.college.managment.college.DTO.TeacherDTO;
import com.college.managment.college.Entity.Teacher;

public interface TeacherService {

	    public void saveTeacher(Teacher teacher);
		
		public TeacherDTO fetchTeacherByEmail(String email);
		
		public TeacherDTO fetchTeacherByNameAndDepartmentAndSubject(Map<String,String> map);
		
		public void deleteTeacherById(Long id);
		
		public void saveAndUpdateTeacher(Teacher teacher);
}
