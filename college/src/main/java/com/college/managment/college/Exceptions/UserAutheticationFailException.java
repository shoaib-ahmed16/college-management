package com.college.managment.college.Exceptions;

public class UserAutheticationFailException extends RuntimeException{

	public UserAutheticationFailException() {
		
	}
	public UserAutheticationFailException(String message) {
		super(message);
	}
}
