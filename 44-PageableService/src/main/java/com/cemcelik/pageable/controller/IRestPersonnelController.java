package com.cemcelik.pageable.controller;

import org.springframework.data.domain.Page;

import com.cemcelik.pageable.model.Personnel;

public interface IRestPersonnelController {
	
	public Page<Personnel> findAllPageable(int pageNumber, int pageSize);

}
