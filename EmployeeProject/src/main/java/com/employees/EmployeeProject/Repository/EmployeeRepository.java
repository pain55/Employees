package com.employees.EmployeeProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.EmployeeProject.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
