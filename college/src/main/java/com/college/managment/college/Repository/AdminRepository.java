package com.college.managment.college.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.college.managment.college.Entity.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin,Long>{

	public Optional<Admin> findByEmail(String email);
}
