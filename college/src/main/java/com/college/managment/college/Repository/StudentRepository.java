package com.college.managment.college.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.college.managment.college.Entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,Long> {
	
	public Optional<Student> findByEmail(String email);	
	public List<Student> findByNameAndBatchAndDepartment(String name,String batch,String department);	
}
