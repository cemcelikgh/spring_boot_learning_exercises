package com.cemcelik.pageable.controller.impl;

import org.springframework.data.domain.Pageable;

import com.cemcelik.pageable.utils.PagerUtil;
import com.cemcelik.pageable.utils.RestPageableRequest;

public class RestBaseController {
	
	public Pageable toPageable(RestPageableRequest request) {
		return PagerUtil.toPagaeble(request);
	}

}
