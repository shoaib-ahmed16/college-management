package com.college.managment.college.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.managment.college.DTO.TeacherDTO;
import com.college.managment.college.DTO.TeacherEmployementRecordDTO;
import com.college.managment.college.Entity.Teacher;
import com.college.managment.college.Exceptions.TeacherNotExistException;
import com.college.managment.college.Exceptions.TeacherNullPointerException;
import com.college.managment.college.Exceptions.TeacherUnknownServerError;
import com.college.managment.college.Repository.TeacherRepository;


@Service
public class TeacherServiceImpl implements TeacherService {

	private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);
	
	@Autowired
	private TeacherRepository teacherRepo;
	
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
			logger.info("Start Fetching the List of  Teachers Detial using Teacher Name: "+name+" Subject: "+subject+" Department: "+department);
				List<Teacher> teachersList=teacherRepo.findByNameAndDepartmentAndSubject(name, department, subject);
				List<TeacherDTO> teachersResult = new ArrayList<>();
				for(Teacher t:teachersList) {
					teachersResult.add(new TeacherDTO(t));
				}
			logger.info("Get the Teachers List by Name, Department and Subject they Teach");	
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
	public String saveAndUpdateTeacher(Teacher teacher) {
		if(teacher.getId()!=null) {
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
				logger.warn("Start Saving the Teacher recoord with updated Fields values");	
					teacherRepo.save(teacherToUpdate);
				logger.info("Teacher record changes saved successfully!");	
				return "Teacher record changes saved successfully!";
			}else {
				//throw new TeacherNotExistException("No teacher Record found for the Teacher Id:"+teacher.getId());
				logger.warn("Start Saving the Teacher Record");	
				   teacherRepo.save(teacher);
			    logger.info("Teacher record  saved successfully!");	
			    return "Teacher record changes saved successfully!";
			}
				
		}else {
			logger.warn("Start Saving the Teacher record");	
				teacherRepo.save(teacher);
			logger.info("Teacher record changes saved successfully!");
			return "Teacher record changes saved successfully!";
		}
		
	}
	
	@Override
	public List<TeacherDTO> fetchAllTeacher() {
		logger.info("Start fetching all Teacher's Records");	
			List<Teacher> teacherList = teacherRepo.findAll();
		logger.info("Get all Teachers Record");
		List<TeacherDTO> resTeacher =new ArrayList<>();
		logger.warn("Start updating all fetched Teacher's Records into Returing List.");
		logger.debug("Start updating all fetched Teacher's Records into Returing List.");
			for(Teacher t:teacherList) {
				resTeacher.add(new TeacherDTO(t));
			}
		logger.debug("All Teacher's Records successfully updated to the Returing List.");	
		logger.info("All Teacher's Records successfully updated to the Returing List.");
		logger.info("Returing List of All teacher's records");
		return resTeacher;
	}

	@Override
	public List<TeacherEmployementRecordDTO> getTeachersEmployeementRecords() {
		logger.info("Start fetching Teacher's  Records");
			List<Teacher> teacherList = teacherRepo.findAll();
		logger.info("Successfully fetch all Teacher's Records");
			List<TeacherEmployementRecordDTO> resTeacher =new ArrayList<>();
		logger.warn("Start updating the List containing the Teacher's Employeement Records");
		logger.debug("Start updating the List containing the Teacher's Employeement Records");
			for(Teacher t:teacherList) {
				resTeacher.add(new TeacherEmployementRecordDTO(t));
			}
		logger.debug("Successfully updated the List containing the Teacher's Employeement Records");
		logger.info("Successfully updated the List containing the Teacher's Employeement Records");
		logger.info("Returning the Teacher's Employeement Records list");
		return resTeacher;
	}
	

	@Override
	public TeacherDTO fetchTeacherById(Long teacherId) {
		if(teacherId!=null) {
			logger.info("Start fetching Teacher Record using Teacher Id: "+teacherId);
				Teacher  teacher=teacherRepo.findById(teacherId)
						.orElseThrow(()->new TeacherNotExistException("No Teacher record found for the TeacherId: "+teacherId));
			logger.info("Get Teacher Record using Teacher Id: "+teacherId);
			return new TeacherDTO(teacher);
		}
		logger.debug("Getting null or Empty value for the TeacherId");
		logger.error("Getting null or Empty value for the TeacherId");
		throw new TeacherNullPointerException("To fetch Teacher Employeement Record Teacher Id cannot be null or Empty");
	}

	@Override
	public TeacherEmployementRecordDTO getTeacherEmployeementRecordByEmailId(String email) {
		if(email!=null) {
			logger.info("Start fetching Teacher Record using Teacher Email Id: "+email);
			Teacher teacher =teacherRepo.findByEmail(email).orElseThrow(()->new TeacherNotExistException("No Record found the teacher using email Id: "+email));
			logger.info("Successfully fetching Teacher Record using Teacher Email Id: "+email);
			return new TeacherEmployementRecordDTO(teacher);
		}
		logger.error("Getting null or Empty value for the Teacher Email Id");
		logger.debug("Getting null or Empty value for the Teacher Email Id");
		throw new TeacherNullPointerException("To fetch Teacher Employeement Record Email Id cannot be null or Empty");
	}

	@Override
	public TeacherEmployementRecordDTO getTeacherEmployeementRecordById(Long teacherId) {
		if(teacherId!=null) {
			logger.info("Start fetching Teacher Record using Teacher  Id: "+teacherId);
			Teacher teacher =teacherRepo.findById(teacherId).orElseThrow(()->new TeacherNotExistException("No Record found the teacher using Teacher Id: "+teacherId));
			logger.info("Successfully fetching Teacher Record using Teacher Id: "+teacherId);
			return new TeacherEmployementRecordDTO(teacher);
		}
		logger.error("Getting null or Empty value for the Teacher Id");
		logger.debug("Getting null or Empty value for the Teacher Id");
		throw new TeacherNullPointerException("To fetch Teacher Employeement Record Teacher Id cannot be null or Empty");
	}

}
