package com.college.managment.college.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.college.managment.college.Entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,Long> {

}
