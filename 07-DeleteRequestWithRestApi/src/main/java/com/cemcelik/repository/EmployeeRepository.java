package com.cemcelik.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cemcelik.model.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private List<Employee> employeeList;

	public List<Employee> getAllEmployeeList() {
		return employeeList;
	}

	public Employee getEmployeeById(String id) {
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				return employee;
			}
		}
		return null;
	}

	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {

		List<Employee> employeeWithParams = new ArrayList<>();

		if (firstName == null && lastName == null) {
			return employeeList;
		}

		for (Employee employee : employeeList) {
			if (firstName != null && lastName != null) {
				if (employee.getFirstName().equalsIgnoreCase(firstName)
						&& employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
				}
			}
			if (firstName != null && lastName == null) {
				if (employee.getFirstName().equalsIgnoreCase(firstName)) {
					employeeWithParams.add(employee);
				}
			}
			if (firstName == null && lastName != null) {
				if (employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
				}
			}
		}

		return employeeWithParams;

	}

	public Employee saveEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
		return newEmployee;
	}

	public boolean deleteEmployee(String id) {
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				employeeList.remove(employee);
				return true;
			}
		}
		return false;
	}

}
