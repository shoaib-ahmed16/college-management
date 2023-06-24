package com.college.managment.college.Exceptions;

public class TeacherNotExistException extends RuntimeException {

	public TeacherNotExistException() {
		
	}
	public TeacherNotExistException(String message) {
		super(message);
	}
}
