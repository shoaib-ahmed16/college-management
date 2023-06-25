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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.managment.college.DTO.LoginUser;
import com.college.managment.college.DTO.StudentDTO;
import com.college.managment.college.Entity.Student;
import com.college.managment.college.Exceptions.StudentDoesNotExistException;
import com.college.managment.college.Exceptions.StudentNullPointerException;
import com.college.managment.college.Exceptions.StudentUnknownErrorException;
import com.college.managment.college.Repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService{

	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired 
	private StudentRepository studentRepo;

	@Override
	public void saveStudents(List<Student> students) {
		try {
		logger.info("Start Saving list of the Students.");
			for(Student s:students) {
				studentRepo.save(s);
			}
		logger.info("All Student's records save successfully");
		}catch(Exception exc) {
			logger.error("Unknown Server error occur while saving the list of students!");
			throw new StudentUnknownErrorException("Unknown Server error occur while saving the list of students :"+exc.getMessage());
		}
	}

	@Override
	public StudentDTO fetchStudentByEmail(String email) {
		logger.info("Start fetching Record for Student using email id: "+email);
		Optional<Student> student = studentRepo.findByEmail(email);
		if(student.isPresent()) {
			logger.info("Get Record for Student using email id: "+email);
			Student resStud =student.get();
			return new StudentDTO(resStud);
		}else {
			logger.error("No Student Record found for Email Id: "+email);
			logger.debug("No Student Record found for Email Id: "+email);
			throw new StudentDoesNotExistException("No Student Record found for Email Id: "+email);
		}
		
	}
	
	@Override
	public List<StudentDTO> fetchStudentByNameAndBatchAndDepartment(Map<String, String> map) {
			String name =null;
			String batch=null;
			String department=null;
			if(map.get("name")!=null) {
				name =String.valueOf(map.get("name"));
			}else {
				logger.error("Name detail is must get the Students record");
				throw new StudentNullPointerException("Name detail is must get the Students record");
			}
			if(map.get("batch")!=null) {
				batch =String.valueOf(map.get("batch"));
			}else {
				logger.error("Batch detail is must get the Students record");
				throw new StudentNullPointerException("Batch detail is must get the Students record");
			}
			if(map.get("department")!=null) {
				department =String.valueOf(map.get("department"));
			}else {
				logger.error("Department detail is must get the Students record");
				throw new StudentNullPointerException("Department detail is must get the Students record");
			}
			logger.info("Start Fetching the Students record on the Bases of Name, Batch, Department they belong");
			logger.debug("Start Fetching the Students record on the Bases of Name, Batch, Department they belong");
			List<Student> students=new ArrayList<>();
			List<StudentDTO> resStudents =new ArrayList<>();
			try {
				students=studentRepo.findByNameAndBatchAndDepartment(name, batch, department);
				logger.info("Get the Students record on the Bases of Name, Batch, Department they belong");
				logger.debug("Get the Students record on the Bases of Name, Batch, Department they belong");
					for(Student s:students) {
						resStudents.add(new StudentDTO(s));
					}
			}catch(Exception exc) {
				logger.error("Unknown Server error occured while fetching the Students Record");
				logger.debug("Unknown Server error occured while fetching the Students Record");
				throw new StudentUnknownErrorException("Unknown Server error occured while fetching the Students Record");
			}
			logger.info("Returning the Students record on the Bases of Name, Batch, Department they belong");
			logger.debug("Returning the Students record on the Bases of Name, Batch, Department they belong");
			return resStudents;
	}

	@Override
	public String deleteStudentById(Long id) {
			logger.info("Start Fetching the Student Record Using the Student Id: "+id);
			Optional<Student> student =studentRepo.findById(id);
			if(student.isPresent()) {
				logger.info("Get the Student Record Using the Student Id: "+id);
				logger.warn("Start Deleting Student Record for the Student Id: "+id);
				studentRepo.delete(student.get());
				logger.info("Student Record: Deleted Successfully for Student Id "+id);
				return "Student Record deleted Successfully!";
			}
			logger.error("No Student Record found for Student Id "+id);
			throw new StudentDoesNotExistException("No Student Record found for Student Id: "+id);
	}

	@Override
	public List<StudentDTO> getAllStudent() {
		try {
			logger.info("Start fetching the Students Record");
				List<Student> findAllStud =studentRepo.findAll();
			logger.info("Get the fetched Students Record");
			List<StudentDTO> resStudlist= new ArrayList<>();
				for(Student s:findAllStud) {
					resStudlist.add(new StudentDTO(s));
				}
			logger.info("returning fetched Students Record");
			return resStudlist;
		}catch(Exception exc) {
			logger.error("Unknown server Error occured while fetching the Students Record");
			throw new StudentUnknownErrorException("Unknown server Error occured while fetching the Students Record: "+exc.getMessage());
		}
	}

	@Override
	public StudentDTO fetchStudentByID(Long id) {
		logger.info("Start fetching the Student Record using Student Id: "+id);
		Optional<Student> student =studentRepo.findById(id);
		if(student.isPresent()) {
			logger.info("Get the Student Record using Student Id: "+id);
			return new StudentDTO(student.get());
		}
		logger.error("No Record found for student using Student Id: "+id);
		throw new StudentDoesNotExistException("No Record found for student using Student Id: "+id);
	}

	@Override
	public String saveStudent(Student student) {
		try {
			logger.info("Ecoding password using { bcryptEncoder } before saving in records");
			logger.info("Adding Permitable Role for Student User:");
			Set<String> roles =student.getRole();
				roles=new HashSet<>();
				roles.add("ROLE_STUDENT");
			student.setRole(roles);
			logger.info("Permitable Role added successfully for Student.");
			 logger.info("Student Record: start Saving...");
			 studentRepo.save(student);
			 logger.info("Student Record: saved successfully!");
			 return "Student Record is saved successfully!";
		}catch(Exception exc) {
			logger.error("Unknown server error occured while saving Student record: "+exc.getMessage());
			throw new StudentUnknownErrorException("Unknown server error occured while saving Student record: "+exc.getMessage());
		}
	}

	@Override
	public String updateStudent(Student student) {
		logger.info("Start fetching for student Record on the bases of Student Id: "+student.getId());
	    Optional<Student> stud =studentRepo.findById(student.getId());
		 if(stud.isPresent())
		 {
			 logger.info("Get student Record search on the bases of Student Id: "+student.getId());
			 logger.info("start Updating the field value change for the fetch Student Record: ");
			 Student studs=stud.get();
			 studs.setBatch(student.getBatch());
			 studs.setDateOfBirth(student.getDateOfBirth());
			 studs.setDepartment(student.getDepartment());
			 studs.setFatherName(student.getFatherName());
			 studs.setMotherName(student.getMotherName());
			 studs.setRole(student.getRole());
			 studs.setName(student.getName());
			 studs.setSubjects(student.getSubjects());
			 logger.info("Update all the field value change for the fetch Student Record: ");
			 studentRepo.save(student);
			 logger.info("Student Record: updated successfully!");
			 return "Student Record is updated successfully!";
		 }
		 logger.error("No Student Record found for the StudentId: "+student.getId());
		 throw new StudentDoesNotExistException("No Student Record found for the StudentId: "+student.getId());
	}

	@Override
	public LoginUser fetchCredentialByEmailId(String email) {
		Optional<Student> student =studentRepo.findByEmail(email);
		if(student.isPresent()) {
			return new LoginUser(student.get());
		}
		return null;
	}

}
