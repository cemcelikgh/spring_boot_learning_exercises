package com.cemcelik.controller;

import com.cemcelik.dto.DtoEmployee;
import com.cemcelik.model.RootEntity;

public interface IRestEmployeeController {

	public RootEntity<DtoEmployee> findEmployeeById(Long id);

}
