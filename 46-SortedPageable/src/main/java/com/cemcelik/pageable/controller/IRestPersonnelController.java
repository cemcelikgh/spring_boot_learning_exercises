package com.cemcelik.pageable.controller;

import org.springframework.data.domain.Page;

import com.cemcelik.pageable.model.Personnel;
import com.cemcelik.pageable.utils.RestPageableRequest;

public interface IRestPersonnelController {
	
	public Page<Personnel> findAllPageable(RestPageableRequest restPageableRequest);

}
