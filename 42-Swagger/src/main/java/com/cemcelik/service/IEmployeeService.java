package com.cemcelik.service;

import com.cemcelik.dto.DtoEmployee;

public interface IEmployeeService {

	DtoEmployee findEmployeeById(Long id);

}
