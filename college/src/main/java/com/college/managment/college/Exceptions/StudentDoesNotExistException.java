package com.college.managment.college.Exceptions;

public class StudentDoesNotExistException extends RuntimeException {
	public StudentDoesNotExistException() {
		
	}
	public StudentDoesNotExistException(String message) {
		super(message);
	}
}
