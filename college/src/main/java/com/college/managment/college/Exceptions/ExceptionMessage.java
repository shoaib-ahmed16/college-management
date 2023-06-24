package com.college.managment.college.Exceptions;

import java.time.LocalDateTime;

public class ExceptionMessage {

	private String message;
	private LocalDateTime localDateTime;
	private String details;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ExceptionMessage(String message, LocalDateTime localDateTime, String details) {
		super();
		this.message = message;
		this.localDateTime = localDateTime;
		this.details = details;
	}
	public ExceptionMessage() {
		super();
	}
}
