package com.employees.EmployeeProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.EmployeeProject.Entity.Employee;
import com.employees.EmployeeProject.Entity.EmployeeSalaryUpdate;
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
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp ) throws Exception {
		
		if(emp == null)
			throw new Exception("Invalid employee details, Try to enter some values");
		
		Employee user =this.employeeService.addEmployee(emp);
		
		return new ResponseEntity<Employee>(user,HttpStatus.CREATED);
		
	}
	
	@PutMapping("employees/{id}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp, @PathVariable long id) throws UserIdNotFoundException {
		if(id>= Long.MAX_VALUE-1 || employeeService.containsEmpId(id) == false )
			throw new UserIdNotFoundException("User id with id(" +id + ") is not present!");
		
		employeeService.updateEmployee(emp);
		
		return ResponseEntity.ok(emp);
	}
	
	
	@PatchMapping("employees/{empId}")
	public ResponseEntity<?> updateEmployeeSalary(@RequestBody EmployeeSalaryUpdate updates, @PathVariable long empId) {
		employeeService.updateEmployeeSalary(updates, empId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("employees/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable long empId) throws UserIdNotFoundException {
		if(employeeService.containsEmpId(empId)==false)
			throw new UserIdNotFoundException("User id with id(" +empId + ") is not present!");
			
		employeeService.deleteEmployee(empId);
		
		return new ResponseEntity<>("Successfully Deleted",HttpStatus.OK);
	}
	
	
}
