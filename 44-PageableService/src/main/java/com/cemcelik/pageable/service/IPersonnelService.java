package com.cemcelik.pageable.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cemcelik.pageable.model.Personnel;

public interface IPersonnelService {
	
	Page<Personnel> findAllPagaable(Pageable pageable);

}
