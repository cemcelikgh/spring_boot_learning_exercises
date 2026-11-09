package com.cemcelik.controller;

import java.util.List;

import com.cemcelik.dto.DtoEmployee;

public interface IEmployeeController {

	public List<DtoEmployee> findAllEmployees();

}
