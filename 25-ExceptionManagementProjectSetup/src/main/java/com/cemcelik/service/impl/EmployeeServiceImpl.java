package com.cemcelik.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoDepartment;
import com.cemcelik.dto.DtoEmployee;
import com.cemcelik.model.Department;
import com.cemcelik.model.Employee;
import com.cemcelik.repository.EmployeeRepository;
import com.cemcelik.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public DtoEmployee findEmployeeById(Long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Employee employee = optional.get();
		Department department = employee.getDepartment();
		DtoEmployee dtoEmployee = new DtoEmployee();
		DtoDepartment dtoDepartment = new DtoDepartment();
		BeanUtils.copyProperties(employee, dtoEmployee);
		BeanUtils.copyProperties(department, dtoDepartment);
		dtoEmployee.setDepartment(dtoDepartment);
		return dtoEmployee;
	}

}
