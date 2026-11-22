package com.cemcelik.pageable.controller.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cemcelik.pageable.utils.PagerUtil;
import com.cemcelik.pageable.utils.RestPageableEntity;
import com.cemcelik.pageable.utils.RestPageableRequest;

public class RestBaseController {
	
	public Pageable toPageable(RestPageableRequest request) {
		return PagerUtil.toPagaeble(request);
	}
	
	public <T> RestPageableEntity<T> toPageableResponse(Page<?> page, List<T> content) {
		return PagerUtil.toPageableResponse(page, content);
	}

}
