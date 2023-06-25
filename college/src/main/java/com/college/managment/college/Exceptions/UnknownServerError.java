package com.college.managment.college.Exceptions;

public class UnknownServerError extends RuntimeException {

	public UnknownServerError() {
		
	}
	public UnknownServerError(String message) {
		super(message);
	}
}
