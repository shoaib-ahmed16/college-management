package com.college.managment.college.Exceptions;

public class TeacherUnknownServerError extends RuntimeException {

	public TeacherUnknownServerError() {
		
	}
	public TeacherUnknownServerError(String message) {
		super(message);
	}
}
