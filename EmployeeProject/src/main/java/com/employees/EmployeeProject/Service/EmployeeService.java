package com.employees.EmployeeProject.Service;

import java.util.List;

import com.employees.EmployeeProject.Entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee emp);
	
	public List<Employee> getEmployees();
	
	public Employee updateEmployee(Employee emp);
}
