package com.cemcelik.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoDepartment;
import com.cemcelik.dto.DtoEmployee;
import com.cemcelik.entities.Employee;
import com.cemcelik.repository.EmployeeRepository;
import com.cemcelik.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<DtoEmployee> findAllEmployees() {
		List<Employee> employeeList = employeeRepository.findAll();
		List<DtoEmployee> dtoEmployeeList = new ArrayList<>();
		if (employeeList != null && !employeeList.isEmpty()) {
			for (Employee employee : employeeList) {
				DtoEmployee dtoEmployee = new DtoEmployee();
				BeanUtils.copyProperties(employee, dtoEmployee);
				dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(), employee.getDepartment().getDepartmentName()));
				dtoEmployeeList.add(dtoEmployee);
			}
		}
		return dtoEmployeeList;
	}

}
