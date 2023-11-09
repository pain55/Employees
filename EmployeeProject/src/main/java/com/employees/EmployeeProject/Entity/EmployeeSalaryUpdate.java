package com.employees.EmployeeProject.Entity;

public class EmployeeSalaryUpdate {

	private long empId;
	private int salary;
	
	
	
	
	public EmployeeSalaryUpdate() {
		// TODO Auto-generated constructor stub
	}
	public EmployeeSalaryUpdate(long empId, int salary) {
		this.empId = empId;
		this.salary = salary;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
