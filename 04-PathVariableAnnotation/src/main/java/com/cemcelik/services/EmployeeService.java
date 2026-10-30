package com.cemcelik.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.model.Employee;
import com.cemcelik.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getlAllEmployeeList() {
		return employeeRepository.getAllEmployeeList();
	}

	public Employee getEmployeeById(String id) {
		return employeeRepository.getEmployeeById(id);
	}

}
