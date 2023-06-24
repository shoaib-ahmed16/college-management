package com.college.managment.college.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.managment.college.DTO.StudentDTO;
import com.college.managment.college.Entity.Student;
import com.college.managment.college.Repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService{

	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired 
	private StudentRepository studentRepo;

	
	@Override
	public void saveStudents(List<Student> students) {
		// TODO Auto-generated method stub
		try {
			for(Student s:students) {
				studentRepo.save(s);
			}
		}catch(Exception exc) {
			exc.getStackTrace();
		}
	}

	@Override
	public StudentDTO fetchStudentByEmail(String email) {
		Student stud=null;
		try {
			stud = studentRepo.findByEmail(email).orElseThrow(()-> new Exception(""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new StudentDTO(stud);
	}

	@Override
	public List<StudentDTO> fetchStudentByNameAndBatchAndDepartment(Map<String, String> map) {
		try {
			String name =null;
			String batch=null;
			String department=null;
			if(map.get("name")!=null) {
				name =String.valueOf(map.get("name"));
			}else {
				throw new Exception("Name detail is must get the record");
			}
			if(map.get("batch")!=null) {
				name =String.valueOf(map.get("batch"));
			}else {
				throw new Exception("Batch detail is must get the record");
			}
			if(map.get("department")!=null) {
				name =String.valueOf(map.get("department"));
			}else {
				throw new Exception("Department detail is must get the record");
			}

			List<Student> students =studentRepo.findByNameAndBatchAndDepartment(name, batch, department);
			List<StudentDTO> resStudents =new ArrayList<>();
			for(Student s:students) {
				resStudents.add(new StudentDTO(s));
			}
			return resStudents;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String saveAndUpdateStudent(Student student) {
		// TODO Auto-generated method stub
		String message ="Student Record is not saved unknown error occured!";
		if(student.getId()!=null) {
		 Optional<Student> stud =studentRepo.findById(student.getId());
		 if(stud.isPresent())
		 {
			 Student studs=stud.get();
			 studs.setBatch(student.getBatch());
			 studs.setDateOfBirth(student.getDateOfBirth());
			 studs.setDepartment(student.getDepartment());
			 studs.setFatherName(student.getFatherName());
			 studs.setMotherName(student.getMotherName());
			 studs.setRole(student.getRole());
			 studs.setName(student.getName());
			 studs.setSubjects(student.getSubjects());
			 studentRepo.save(student);
			 return "Student Record is updated successfully!";
		 }else
		 {
			 studentRepo.save(student);
			 return "Student Record is saved successfully!";
		 }
		}
		return message; 
	}

	@Override
	public String deleteStudentById(Long id) {
		String message="While deleting Student Record unknown Error occured!";
		try {
			Student stud =studentRepo.findById(id).orElseThrow(()->new Exception(""));
			studentRepo.delete(stud);
			return "Student Record deleted Successfully!";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
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

	@Override
	public StudentDTO fetchStudentByID(Long id) {
		// TODO Auto-generated method stub
		Student student =null;
		try {
			student =studentRepo.findById(id).orElseThrow(()->new Exception(""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new StudentDTO(student);
	}

}
