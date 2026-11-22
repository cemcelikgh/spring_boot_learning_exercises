package com.cemcelik.pageable.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cemcelik.pageable.controller.IRestPersonnelController;
import com.cemcelik.pageable.model.Personnel;
import com.cemcelik.pageable.service.IPersonnelService;

@RestController
@RequestMapping("/rest/api/personnal")
public class RestPersonnalController implements IRestPersonnelController {
	
	@Autowired
	private IPersonnelService personnelService;

	@GetMapping("/list/pageable")
	@Override
	public Page<Personnel> findAllPageable(@RequestParam(value = "pageNumber") int pageNumber,
			@RequestParam(value = "pageSize") int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Direction.DESC, "id"));
		return personnelService.findAllPagaable(pageable);
	}

}
