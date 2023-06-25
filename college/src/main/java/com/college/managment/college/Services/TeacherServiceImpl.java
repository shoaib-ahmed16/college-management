package com.college.managment.college.Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.managment.college.DTO.LoginUser;
import com.college.managment.college.DTO.TeacherDTO;
import com.college.managment.college.DTO.TeacherEmployementRecordDTO;
import com.college.managment.college.DTO.UserPasswordUpdateDTO;
import com.college.managment.college.Entity.Teacher;
import com.college.managment.college.Exceptions.TeacherNotExistException;
import com.college.managment.college.Exceptions.TeacherUnknownServerError;
import com.college.managment.college.Repository.TeacherRepository;


@Service
public class TeacherServiceImpl implements TeacherService {

	private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Override
	public TeacherDTO fetchTeacherByEmail(String email) {
		logger.info("Start Fetching the Teacher Detials using Teacher EmailId: "+email);
			Optional<Teacher>  teacher =teacherRepo.findByEmail(email);
			if(teacher.isPresent()) {
				logger.info("Get Teacher Detials using Teacher EmailId: "+email);
			    return new TeacherDTO(teacher.get());
			}
		logger.error("No Teacher Record Found for the Email Id: "+email);    
		throw new TeacherNotExistException("No Teacher Record Found for the Email Id: "+email);
	}

	@Override
	public List<TeacherDTO> fetchTeacherByNameAndDepartmentAndSubject(Map<String, String> map) {
		String name=null;
		String department=null;
		String subject=null;
		    if(map.get("name")!=null) {
				name=String.valueOf(map.get("name"));
			}else {
				logger.error("Teacher Name cannot be Empty or null value");
				throw new TeacherUnknownServerError("Teacher Name cannot be Empty or null");
			}
			if(map.get("department")!=null) {
				department=String.valueOf(map.get("department"));
			}else {
				logger.error("Teacher Department cannot be Empty or null value");
				throw new TeacherUnknownServerError("Teacher Department cannot be Empty or null");
			
			}
			if(map.get("subject")!=null) {
				subject=String.valueOf(map.get("subject"));
			}else {
				logger.error("Teacher Subject cannot be Empty or null value");
				throw new TeacherUnknownServerError("Teacher Subject cannot be Empty or null");
			}
			List<TeacherDTO> teachersResult = new ArrayList<>();
			try {
				logger.info("Start Fetching the List of  Teachers Detial using Teacher Name: "+name+" Subject: "+subject+" Department: "+department);
				List<Teacher> teachersList=teacherRepo.findByNameAndDepartmentAndSubject(name, department, subject);
					for(Teacher t:teachersList) {
						teachersResult.add(new TeacherDTO(t));
					}
				logger.info("Get the Teachers List by Name, Department and Subject they Teach");
			}catch(Exception exc) {
				logger.error("Unknown server error occured while fetching the Teachers List: "+exc.getMessage());
				throw new TeacherUnknownServerError("Unknown server error occured while fetching the Teachers List: "+exc.getMessage());
			}
			return teachersResult;
	}

	@Override
	public String deleteTeacherById(Long id) {
			logger.info("Start fetching the details for Teacher by Teacher Id: "+id);	
			Optional<Teacher> teacher=teacherRepo.findById(id);
			if(teacher.isPresent()) {
				logger.warn("Start Deleting the Teacher details for Teacher Id: "+id);	
				teacherRepo.delete(teacher.get());
				logger.warn("Teacher details deleted Successfully for Teacher Id: "+id);	
			}else
				throw new TeacherNotExistException("No teacher Record found for the Teacher Id:"+id);
		return "Teacher record deleted successfully";
	}

	
	@Override
	public List<TeacherDTO> fetchAllTeacher() {
		List<TeacherDTO> resTeacher =new ArrayList<>();
		try {
			logger.info("Start fetching all Teacher's Records");	
			List<Teacher> teacherList = teacherRepo.findAll();
			logger.info("Get all Teachers Record");
			for(Teacher t:teacherList) {
				resTeacher.add(new TeacherDTO(t));
			}
			logger.info("Returing List of All teacher's records");
		}catch(Exception exc) {
			logger.error("Unknown server errors occured while fetching teachers list: "+exc.getMessage());
			throw new TeacherUnknownServerError("Unknown server errors occured while fetching teachers list: "+exc.getMessage());
		}
		return resTeacher;
	}

	@Override
	public List<TeacherEmployementRecordDTO> getTeachersEmployeementRecords() {
		List<TeacherEmployementRecordDTO> resTeacher =new ArrayList<>();
		try {
		logger.info("Start fetching Teacher's  Records");
			List<Teacher> teacherList = teacherRepo.findAll();
		logger.info("Successfully fetch all Teacher's Records");
			for(Teacher t:teacherList) {
				resTeacher.add(new TeacherEmployementRecordDTO(t));
			}
		logger.info("Returning the Teacher's Employeement Records list");
		}catch(Exception exc) {
			logger.error("unknown server error occured while fetching the Teachers list: "+exc.getMessage());
			throw new TeacherUnknownServerError("unknown server error occured while fetching the Teachers list: "+exc.getMessage());
		}
		return resTeacher;
	}
	

	@Override
	public TeacherDTO fetchTeacherById(Long teacherId) {
		logger.info("Start fetching Teacher Record using TeacherId: "+teacherId);
		Optional<Teacher>  teacher=teacherRepo.findById(teacherId);
		if(teacher.isPresent()) {
			logger.info("Get Teacher Record using Teacher Id: "+teacherId);
			return new TeacherDTO(teacher.get());
		}
		logger.debug("No Teacher record found for the TeacherId: "+teacherId);
		logger.error("No Teacher record found for the TeacherId: "+teacherId);
		throw new TeacherNotExistException("No Teacher record found for the TeacherId: "+teacherId);
	}

	@Override
	public TeacherEmployementRecordDTO getTeacherEmployeementRecordByEmailId(String email) {
		logger.info("Start fetching Teacher Record using Teacher Email Id: "+email);
		Optional<Teacher> teacher =teacherRepo.findByEmail(email);
		if(teacher.isPresent()) {
			//.orElseThrow(()->;
			logger.info("Get Teacher Record using Teacher Email Id: "+email);
			return new TeacherEmployementRecordDTO(teacher.get());
		}
		logger.error("No Record found for the Teacher Email Id");
		logger.debug("No Record found for the Teacher Email Id");
		throw new TeacherNotExistException("No Record found the teacher using email Id: "+email);
}

	@Override
	public TeacherEmployementRecordDTO getTeacherEmployeementRecordById(Long teacherId) {
		logger.info("Start fetching Teacher Record using Teacher  Id: "+teacherId);
			Optional<Teacher> teacher =teacherRepo.findById(teacherId);
		if(teacher.isPresent()) {
			logger.info("get Teacher Record using Teacher Id: "+teacherId);
			return new TeacherEmployementRecordDTO(teacher.get());
		}
		logger.error("No Record found the teacher using Teacher Id: "+teacherId);
		logger.debug("No Record found the teacher using Teacher Id: "+teacherId);
		throw new TeacherNotExistException("No Record found the teacher using Teacher Id: "+teacherId);
	}

	@Override
	public String save(Teacher teacher) {
		try {
			logger.info("Ecoding password using { bcryptEncoder } before saving in records");
			teacher.setPassword(bcryptEncoder.encode(teacher.getPassword()));
			logger.info("Adding Permitable Role for Teacher User:");
			Set<String> roles =teacher.getRole();
				roles=new HashSet<>();
				roles.add("TEACHER");
				roles.add("STUDENT");
			teacher.setRole(roles);
			logger.info("Permitable Role added successfully for Teacher.");
		
			logger.warn("Start Saving the Teacher Record");	
			   teacherRepo.save(teacher);
		    logger.info("Teacher record  saved successfully!");	
		    return "Teacher record changes saved successfully!";
		}catch(Exception exc) {
			logger.error("Unknown Server error occured while saving Teacher Record: "+exc.getMessage());
			throw new TeacherUnknownServerError("Unknown Server error occured while saving Teacher Record: "+exc.getMessage());
		}
	}

	@Override
	public String update(Teacher teacher) {
			Optional<Teacher> teach=teacherRepo.findById(teacher.getId());
			if(teach.isPresent())
			{
				Teacher teacherToUpdate=teach.get();
				logger.info("Start Updating changes field values in Existing Teacher record");	
					teacherToUpdate.setDepartment(teacher.getDepartment());
					teacherToUpdate.setEmail(teacher.getEmail());
					teacherToUpdate.setJoiningDate(teacher.getJoiningDate());
					teacherToUpdate.setLastWorkingDate(teacher.getLastWorkingDate());
					teacherToUpdate.setListBatches(teacher.getListBatches());
					teacherToUpdate.setMarriageStatus(teacher.getMarriageStatus());
					teacherToUpdate.setName(teacher.getName());
					teacherToUpdate.setReposibility(teacher.getReposibility());
					teacherToUpdate.setSalary(teacher.getSalary());
					teacherToUpdate.setSpouseOrHusbandName(teacher.getSpouseOrHusbandName());
					teacherToUpdate.setSubject(teacher.getSubject());;
					teacherToUpdate.setWorkingStatus(teacher.getWorkingStatus());
					teacherToUpdate.setRole(teacher.getRole());
				logger.warn("Start Saving the Teacher recoord with updated Fields values");	
					teacherRepo.save(teacherToUpdate);
				logger.info("Teacher record changes saved successfully!");	
				return "Teacher record changes saved successfully!";
			}
			throw new TeacherNotExistException("No Previous Record found for the Teacher object to update the Existing Teacher Record.");
	}

	@Override
	public String passwordUpdate(UserPasswordUpdateDTO passwordUpdate) {
		try {
			logger.info("Start Fetching the Teacher Detials using Teacher Email Id: "+ passwordUpdate.getEmail() +"for updating password");
			Optional<Teacher>  teacher =teacherRepo.findByEmail(passwordUpdate.getEmail());
			if(teacher.isPresent()) {
				Teacher teach=teacher.get();
				logger.info("Ecoding password using { bcryptEncoder } before updating to the records");
				teach.setPassword(bcryptEncoder.encode(passwordUpdate.getNewPassword()));
				logger.warn("Updating Teacher record with the new password");
				teacherRepo.save(teach);
				logger.info("Teacher new password updated successfully!");
				return "Teacher new password updated successfully!";
			}
			throw new TeacherNotExistException("Invalid User Email ID or Wrong Email ID");
		}catch(Exception exc) {
			logger.error("Unknown Server error occured while updating the new Password!");
			throw new TeacherUnknownServerError("Unknown Server error occured while updating the new Password!");
		}
	}

}
