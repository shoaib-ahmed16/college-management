package com.college.managment.college.Exceptions;

public class AdminDoesNotExistException extends RuntimeException {

	public AdminDoesNotExistException() {}
    public AdminDoesNotExistException(String message) {
		super(message);
	}
}
