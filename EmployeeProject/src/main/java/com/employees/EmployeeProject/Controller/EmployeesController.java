package com.employees.EmployeeProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.EmployeeProject.Entity.Employee;
import com.employees.EmployeeProject.Exceptions.UserIdNotFoundException;
import com.employees.EmployeeProject.Service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
public class EmployeesController {

	private EmployeeService employeeService;
	
	public EmployeesController() {
		
	}
	
	@Autowired
	public EmployeesController(EmployeeService empService) {
		employeeService = empService;
	}
	
	
	@GetMapping("employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	@GetMapping("employees/{empId}")
	public Employee getEmployee(@PathVariable long empId) throws UserIdNotFoundException {
		if(empId<1 || empId>= Long.MAX_VALUE)
			throw new UserIdNotFoundException("User id with id(" + empId + ") is not present!");
		
		return employeeService.getEmployee(empId);
	}
	
	
	@PostMapping("employees/") 
	public Employee addEmployee(@RequestBody Employee emp ) {
		
		return this.employeeService.addEmployee(emp);
	}
	
	@PutMapping("employees/{id}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp, @PathVariable long id) throws UserIdNotFoundException {
		if(id>= Long.MAX_VALUE-1 || employeeService.containsEmpId(id) == false )
			throw new UserIdNotFoundException("User id with id(" +id + ") is not present!");
		
		
		employeeService.updateEmployee(emp);
		
		return ResponseEntity.ok(emp);
	}
	
	
	
}
