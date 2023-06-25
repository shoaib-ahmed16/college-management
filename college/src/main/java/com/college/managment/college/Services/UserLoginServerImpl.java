package com.college.managment.college.Services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.managment.college.DTO.LoginUser;
import com.college.managment.college.Entity.Admin;
import com.college.managment.college.Entity.Student;
import com.college.managment.college.Entity.Teacher;
import com.college.managment.college.Exceptions.UserCredentialNotFoundException;
import com.college.managment.college.Repository.AdminRepository;
import com.college.managment.college.Repository.StudentRepository;
import com.college.managment.college.Repository.TeacherRepository;

@Service(value = "userService")
public class UserLoginServerImpl implements UserDetailsService, UserLoginServer {

	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired 
	private StudentRepository studentRepo;

	@Autowired
	private TeacherRepository teacherRepo;
   
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginUser user =null;
		Optional<Admin> admin =adminRepo.findByEmail(username);
		if(admin.isPresent()) {
			user=new LoginUser(admin.get());
		  return new User(user.getUsername(), user.getPassword(), getAuthority(user));
		}
		Optional<Teacher> teacher =teacherRepo.findByEmail(username);
	    if(teacher.isPresent()){
	    	user=new LoginUser(teacher.get());
			return new User(user.getUsername(), user.getPassword(), getAuthority(user));
	    }
	    Optional<Student> student =studentRepo.findByEmail(username);
	    if(student.isPresent()){
	    	user=new LoginUser(student.get());
			return new User(user.getUsername(), user.getPassword(), getAuthority(user));
	    }
		throw new UserCredentialNotFoundException("Invalid Username or Password");
	}
	private Set<SimpleGrantedAuthority> getAuthority(LoginUser user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()));
        });
        return authorities;
    }
}
