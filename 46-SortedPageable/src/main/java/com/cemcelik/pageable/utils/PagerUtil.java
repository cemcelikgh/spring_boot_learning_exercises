package com.cemcelik.pageable.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PagerUtil {

	public boolean isNullOrEmpty(String value) {
		return value == null || value.trim().length() == 0;
	}

	public Pageable toPagaeble(RestPageableRequest request) {
		if (!isNullOrEmpty(request.getColumnName())) {
			Sort sortBy = request.isAsc() ? Sort.by(Direction.ASC, request.getColumnName())
					: Sort.by(Direction.DESC, request.getColumnName());
			return PageRequest.of(request.getPageNumber(), request.getPageSize(), sortBy);
		}
		return PageRequest.of(request.getPageNumber(), request.getPageSize());
	}

}
