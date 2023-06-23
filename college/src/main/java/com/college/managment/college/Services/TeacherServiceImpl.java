package com.college.managment.college.Services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.college.managment.college.DTO.TeacherDTO;
import com.college.managment.college.DTO.TeacherEmployementRecordDTO;
import com.college.managment.college.Entity.Teacher;


@Service
public class TeacherServiceImpl implements TeacherService {

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

	@Override
	public List<TeacherDTO> fetchAllTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeacherEmployementRecordDTO> getTeachersEmployeementRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherEmployementRecordDTO getTeacherEmployeementRecordByEmailId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherDTO fetchTeacherById(Long teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

}
