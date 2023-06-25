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
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(UnknownServerError ucnf,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(ucnf.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(UserAutheticationFailException ucnf,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(ucnf.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(UserCredentialNotFoundException ucnf,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(ucnf.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(AdminDoesNotExistException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(AdminNullPointerException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(AdminUnknownServerError np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(StudentDoesNotExistException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(StudentNullPointerException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(StudentUnknownErrorException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(TeacherNotExistException tne,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(tne.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(TeacherNullPointerException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(TeacherUnknownServerError tuse,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(tuse.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(NullPointerException np,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> collegeErrorHandler(Exception exc,WebRequest req)
	{
		ExceptionMessage err = new ExceptionMessage(exc.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
