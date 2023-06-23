package com.college.managment.college.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.college.managment.college.Entity.Teacher;
@Repository
public interface TeacherRepository extends MongoRepository<Teacher,Long> {

	public Optional<Teacher> findByEmail(String email);
	public List<Teacher> findByNameAndDepartmentAndSubject(String name, String department,String subject);
}
