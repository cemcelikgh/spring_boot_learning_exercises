package com.cemcelik.pageable.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cemcelik.pageable.dto.DtoPersonnel;
import com.cemcelik.pageable.model.Personnel;

public interface IPersonnelService {
	
	Page<Personnel> findAllPagaable(Pageable pageable);
	
	List<DtoPersonnel> toDtoList(List<Personnel> personnelList);

}
