package com.cemcelik.services;

import java.util.List;

import com.cemcelik.dto.DtoEmployee;

public interface IEmployeeService {

	public List<DtoEmployee> findAllEmployees();

}
