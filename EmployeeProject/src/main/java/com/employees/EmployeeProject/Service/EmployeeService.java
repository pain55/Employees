package com.employees.EmployeeProject.Service;

import java.util.List;
import java.util.Map;

import com.employees.EmployeeProject.Entity.Employee;
import com.employees.EmployeeProject.Entity.EmployeeSalaryUpdate;

public interface EmployeeService {
	
	public Employee addEmployee(Employee emp);
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(long empId);
	
	public Employee updateEmployee(Employee emp);
	
	public Employee updateEmployeeSalary(EmployeeSalaryUpdate update, long empId);
	
	public void deleteEmployee(long empId);
	
	public boolean containsEmpId(long empId);
}
