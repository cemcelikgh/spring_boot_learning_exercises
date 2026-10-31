package com.cemcelik.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.model.Employee;
import com.cemcelik.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final List<Employee> employeeList;
	@Autowired
	private EmployeeRepository employeeRepository;

	EmployeeService(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Employee> getlAllEmployeeList() {
		return employeeRepository.getAllEmployeeList();
	}

	public Employee getEmployeeById(String id) {
		return employeeRepository.getEmployeeById(id);
	}

	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
		return employeeRepository.getEmployeeWithParams(firstName, lastName);
	}

	public Employee saveEmployee(Employee newEmployee) {
		return employeeRepository.saveEmployee(newEmployee);
	}
	
	public boolean deleteEmployee(String id) {
		return employeeRepository.deleteEmployee(id);
	}

}
