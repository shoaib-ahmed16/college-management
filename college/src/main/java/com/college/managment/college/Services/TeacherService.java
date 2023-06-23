package com.college.managment.college.Services;

import java.util.List;
import java.util.Map;

import com.college.managment.college.DTO.TeacherDTO;
import com.college.managment.college.DTO.TeacherEmployementRecordDTO;
import com.college.managment.college.Entity.Teacher;

public interface TeacherService {
		
		public TeacherDTO fetchTeacherByEmail(String email);
		
		public TeacherDTO fetchTeacherByNameAndDepartmentAndSubject(Map<String,String> map);
		
		public List<TeacherDTO> fetchAllTeacher();
		
		public TeacherDTO fetchTeacherById(Long teacherId);
		
		public void deleteTeacherById(Long id);
		
		public void saveAndUpdateTeacher(Teacher teacher);
		
		public List<TeacherEmployementRecordDTO> getTeachersEmployeementRecords();
		
		public TeacherEmployementRecordDTO getTeacherEmployeementRecordByEmailId();
}
