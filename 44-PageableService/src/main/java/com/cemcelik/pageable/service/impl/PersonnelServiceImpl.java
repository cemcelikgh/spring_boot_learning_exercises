package com.cemcelik.pageable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cemcelik.pageable.model.Personnel;
import com.cemcelik.pageable.repository.PersonnelRepository;
import com.cemcelik.pageable.service.IPersonnelService;

@Service
public class PersonnelServiceImpl implements IPersonnelService {
	
	@Autowired
	private PersonnelRepository personnelRepository;

	@Override
	public Page<Personnel> findAllPagaable(Pageable pageable) {
		Page<Personnel> page = personnelRepository.findAllPagaable(pageable);
		return page;
	}

}
