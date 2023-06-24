package com.college.managment.college.Exceptions;

public class StudentUnknownErrorException extends RuntimeException {

	public StudentUnknownErrorException() {
		
	}
	public StudentUnknownErrorException(String message) {
		super(message);
	}
}
