package com.college.managment.college.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.managment.college.DTO.TeacherDTO;
import com.college.managment.college.DTO.TeacherEmployementRecordDTO;
import com.college.managment.college.Entity.Student;
import com.college.managment.college.Entity.Teacher;
import com.college.managment.college.Repository.TeacherRepository;


@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepo;
	
	@Override
	public TeacherDTO fetchTeacherByEmail(String email) {
		Teacher teacher=null;
		try {
		    teacher =teacherRepo.findByEmail(email).orElseThrow(()->new RuntimeException("No Teacher record found"));
		    return new TeacherDTO(teacher);
		}catch(Exception exc) {
			exc.getMessage();
		}
		throw new RuntimeException("No Teacher record found");
	}

	@Override
	public List<TeacherDTO> fetchTeacherByNameAndDepartmentAndSubject(Map<String, String> map) {
		String name=null;
		String department=null;
		String subject=null;
		try {
		    if(map.get("name")!=null) {
				name=String.valueOf(map.get("name"));
			}else
				throw new RuntimeException("Teacher Name cannot be Empty or null");
			if(map.get("department")!=null) {
				department=String.valueOf(map.get("department"));
			}else
				throw new RuntimeException("Teacher Department cannot be Empty or null");
			if(map.get("subject")!=null) {
				name=String.valueOf(map.get("subject"));
			}else
				throw new RuntimeException("Teacher Subject cannot be Empty or null");
			List<Teacher> teachers=teacherRepo.findByNameAndDepartmentAndSubject(name, department, subject);
			List<TeacherDTO> teacherDto = new ArrayList<>();
			for(Teacher t:teachers) {
				teacherDto.add(new TeacherDTO(t));
			}
			return teacherDto;
		}catch(Exception exc) {
			exc.getMessage();
		}
		throw new RuntimeException("Unknown server error occured!");
	}

	@Override
	public void deleteTeacherById(Long id) {
		try {
			Teacher teacher=teacherRepo.findById(id).orElseThrow(()->new RuntimeException("No Teacher record found for the Id"));
			teacherRepo.delete(teacher);
		}catch(Exception exc) {
			exc.getMessage();
		}
	}

	@Override
	public String saveAndUpdateTeacher(Teacher teacher) {
		String message ="Student Record is not saved unknown error occured!";
		if(teacher.getId()!=null) {
			Teacher teach=teacherRepo.findById(teacher.getId()).orElse(teacherRepo.save(teacher));
			teach.setDepartment(teacher.getDepartment());
			teach.setEmail(teacher.getEmail());
			teach.setJoiningDate(teacher.getJoiningDate());
			teach.setLastWorkingDate(teacher.getLastWorkingDate());
			teach.setListBatches(teacher.getListBatches());
			teach.setMarriageStatus(teacher.getMarriageStatus());
			teach.setName(teacher.getName());
			teach.setReposibility(teacher.getReposibility());
			teach.setSalary(teacher.getSalary());
			teach.setSpouseOrHusbandName(teacher.getSpouseOrHusbandName());
			teach.setSubject(teacher.getSubject());;
			teach.setWorkingStatus(teacher.getWorkingStatus());
			teacherRepo.save(teach);
		}
		return message; 
		
	}

	@Override
	public List<TeacherDTO> fetchAllTeacher() {
		try {
			List<Teacher> teacherList = teacherRepo.findAll();
			List<TeacherDTO> resTeacher =new ArrayList<>();
			for(Teacher t:teacherList) {
				resTeacher.add(new TeacherDTO(t));
			}
			return resTeacher;
		}catch(Exception exc) {
			exc.getMessage();
		}
		throw new RuntimeException("Unknown Server error!");
	}

	@Override
	public List<TeacherEmployementRecordDTO> getTeachersEmployeementRecords() {
		try {
			List<Teacher> teacherList = teacherRepo.findAll();
			List<TeacherEmployementRecordDTO> resTeacher =new ArrayList<>();
			for(Teacher t:teacherList) {
				resTeacher.add(new TeacherEmployementRecordDTO(t));
			}
			return resTeacher;
		}catch(Exception exc) {
			exc.getMessage();
		}
		throw new RuntimeException("Unknown Server error!");
	}

	@Override
	public TeacherEmployementRecordDTO getTeacherEmployeementRecordByEmailId(String email,Long id) {
		Teacher  teacher =null;
		try {
		teacher=teacherRepo.findByEmail(email)
				.orElseThrow(()->new RuntimeException("No Teacher record found for the Email"));
		return new TeacherEmployementRecordDTO(teacher);
		}catch(RuntimeException exc) {
		 teacher=teacherRepo.findById(id)
					.orElseThrow(()->new RuntimeException("No Teacher record found for the Id"));
		 return new TeacherEmployementRecordDTO(teacher);
		}catch(Exception exc) {
			System.out.println("No Teacher record found for the Email or Id");
		}
		throw new RuntimeException("No Teacher record found for the  Email or Id");
	}

	@Override
	public TeacherDTO fetchTeacherById(Long teacherId) {
		Teacher  teacher =null;
		try {
			teacher=teacherRepo.findById(teacherId)
					.orElseThrow(()->new RuntimeException("No Teacher record found for the TeacherId"));
			  return new TeacherDTO(teacher);
		}catch(RuntimeException exc) {
			exc.getMessage();
		}
		throw new RuntimeException("Unknown Server Error");
	}

}
