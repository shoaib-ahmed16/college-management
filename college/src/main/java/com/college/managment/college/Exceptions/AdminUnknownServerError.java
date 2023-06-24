package com.college.managment.college.Exceptions;

public class AdminUnknownServerError extends RuntimeException {

	public AdminUnknownServerError() {
		
	}
	public AdminUnknownServerError(String message) {
		super(message);
	}
}
