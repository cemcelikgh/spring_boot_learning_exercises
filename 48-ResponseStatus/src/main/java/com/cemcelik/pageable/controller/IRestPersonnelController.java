package com.cemcelik.pageable.controller;

import com.cemcelik.pageable.dto.DtoPersonnel;
import com.cemcelik.pageable.utils.RestPageableEntity;
import com.cemcelik.pageable.utils.RestPageableRequest;
import com.cemcelik.pageable.utils.RestRootEntity;

public interface IRestPersonnelController {
	
	public RestRootEntity<RestPageableEntity<DtoPersonnel>> findAllPageable(RestPageableRequest restPageableRequest);

}
