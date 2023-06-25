package com.college.managment.college.Exceptions;

public class UserCredentialNotFoundException extends RuntimeException{

	public UserCredentialNotFoundException() {
		
	}
	public UserCredentialNotFoundException(String message) {
		super(message);
	}
}
