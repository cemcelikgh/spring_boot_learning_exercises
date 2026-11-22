package com.cemcelik.pageable.controller;

import com.cemcelik.pageable.dto.DtoPersonnel;
import com.cemcelik.pageable.utils.RestPageableEntity;
import com.cemcelik.pageable.utils.RestPageableRequest;

public interface IRestPersonnelController {
	
	public RestPageableEntity<DtoPersonnel> findAllPageable(RestPageableRequest restPageableRequest);

}
