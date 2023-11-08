package com.employees.EmployeeProject.Exceptions;

@SuppressWarnings("serial")
public class UserIdNotFoundException extends Exception{
	
	public UserIdNotFoundException(String message) {
		
		super(message);
	}
}
