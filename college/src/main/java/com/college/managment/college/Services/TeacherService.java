package com.college.managment.college.Services;

import java.util.List;
import java.util.Map;

import com.college.managment.college.DTO.LoginUser;
import com.college.managment.college.DTO.TeacherDTO;
import com.college.managment.college.DTO.TeacherEmployementRecordDTO;
import com.college.managment.college.DTO.UserPasswordUpdateDTO;
import com.college.managment.college.Entity.Student;
import com.college.managment.college.Entity.Teacher;

public interface TeacherService {
	
		public String passwordUpdate(UserPasswordUpdateDTO passwordUpdate);
		
		public TeacherDTO fetchTeacherByEmail(String email);
		
		public List<TeacherDTO> fetchTeacherByNameAndDepartmentAndSubject(Map<String,String> map);
		
		public List<TeacherDTO> fetchAllTeacher();
		
		public TeacherDTO fetchTeacherById(Long teacherId);
		
		public String deleteTeacherById(Long id);
		
		public String save(Teacher teacher);
		
		public String update(Teacher teacher);
		
		public List<TeacherEmployementRecordDTO> getTeachersEmployeementRecords();
		
		public TeacherEmployementRecordDTO getTeacherEmployeementRecordByEmailId(String email);
		
		public TeacherEmployementRecordDTO getTeacherEmployeementRecordById(Long teacherId);
}
