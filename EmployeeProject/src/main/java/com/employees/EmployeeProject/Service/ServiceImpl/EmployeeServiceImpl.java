package com.employees.EmployeeProject.Service.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.EmployeeProject.Entity.Employee;
import com.employees.EmployeeProject.Entity.EmployeeSalaryUpdate;
import com.employees.EmployeeProject.Exceptions.UserIdNotFoundException;
import com.employees.EmployeeProject.Repository.EmployeeRepository;
import com.employees.EmployeeProject.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	
	EmployeeServiceImpl() {
		
	}
	
	@Autowired
	public EmployeeServiceImpl( EmployeeRepository theEmpoyeeRepo ) {
		employeeRepository = theEmpoyeeRepo;
	}
	
	
	
	
	@Override
	public Employee addEmployee(Employee emp) {
		Employee user = employeeRepository.save(emp);
		
		return user;
	}

	@Override
	public List<Employee> getEmployees() {
		
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee getEmployee(long empId) {
		return employeeRepository.findById(empId).orElseThrow();
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		
		return employeeRepository.save(emp);
	}
	
	@Override
	public Employee updateEmployeeSalary(EmployeeSalaryUpdate updates, long empId) {
		
		Employee emp = this.getEmployee(empId);
		
		emp.setSalary(updates.getSalary());
		
		return this.employeeRepository.save(emp);
		
	}
	
	@Override
	public void deleteEmployee(long empId) {
		employeeRepository.deleteById(empId);
	}
	
	
	
	@Override
	public boolean containsEmpId(long empId) {
		return employeeRepository.existsById(empId);
	}
	
}
