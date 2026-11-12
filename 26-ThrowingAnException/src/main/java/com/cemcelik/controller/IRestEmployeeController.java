package com.cemcelik.controller;

import com.cemcelik.dto.DtoEmployee;

public interface IRestEmployeeController {

	public DtoEmployee findEmployeeById(Long id);

}
