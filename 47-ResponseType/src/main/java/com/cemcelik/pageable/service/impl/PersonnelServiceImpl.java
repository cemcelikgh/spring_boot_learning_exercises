package com.cemcelik.pageable.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cemcelik.pageable.dto.DtoDepartment;
import com.cemcelik.pageable.dto.DtoPersonnel;
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

	@Override
	public List<DtoPersonnel> toDtoList(List<Personnel> personnelList) {
		List<DtoPersonnel> dtoPersonnelList = new ArrayList<>();
		for (Personnel personnel : personnelList) {
			DtoPersonnel dtoPersonnel = new DtoPersonnel();
			DtoDepartment dtoDepartment = new DtoDepartment();
			BeanUtils.copyProperties(personnel, dtoPersonnel);
			BeanUtils.copyProperties(personnel.getDepartment(), dtoDepartment);
			dtoPersonnel.setDepartment(dtoDepartment);
			dtoPersonnelList.add(dtoPersonnel);
			
		}
		return dtoPersonnelList;
	}

}
