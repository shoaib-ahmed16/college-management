package com.college.managment.college.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CollegeGlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> myErrorHandler(AdminDoesNotExistException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> myErrorHandler(AdminNullPointerException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> myErrorHandler(AdminUnknownServerError np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> myErrorHandler(StudentDoesNotExistException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> myErrorHandler(StudentNullPointerException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> myErrorHandler(StudentUnknownErrorException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> myErrorHandler(TeacherNotExistException tne,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(tne.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> myErrorHandler(TeacherNullPointerException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> myErrorHandler(TeacherUnknownServerError tuse,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(tuse.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> myErrorHandler(NullPointerException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> myErrorHandler(Exception exc,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(exc.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
