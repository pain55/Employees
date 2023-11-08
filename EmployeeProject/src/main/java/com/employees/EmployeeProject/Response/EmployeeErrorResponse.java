package com.employees.EmployeeProject.Response;

import org.springframework.http.HttpStatus;

public class EmployeeErrorResponse {

	private int status;
	private String message;
	private long timeStamp;
	
	
	
	
	
	
	public EmployeeErrorResponse() {
		// TODO Auto-generated constructor stub
	}
	public EmployeeErrorResponse(int status, String message, long timeStamp) {
		this.setStatus(status);
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
