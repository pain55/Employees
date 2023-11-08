package com.employees.EmployeeProject.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employees.EmployeeProject.Exceptions.UserIdNotFoundException;
import com.employees.EmployeeProject.Response.EmployeeErrorResponse;

@RestControllerAdvice
public class EmployeeRestExceptionHandler {

	

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(UserIdNotFoundException empException) {
		
		EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
		
		employeeErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		employeeErrorResponse.setMessage(empException.getMessage());
		employeeErrorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployeeErrorResponse>(employeeErrorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<?> handleException(Exception exception) {
		EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
		
		employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		employeeErrorResponse.setMessage(exception.getMessage());
		employeeErrorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployeeErrorResponse>(employeeErrorResponse,HttpStatus.BAD_REQUEST);
	}
	
	
}
