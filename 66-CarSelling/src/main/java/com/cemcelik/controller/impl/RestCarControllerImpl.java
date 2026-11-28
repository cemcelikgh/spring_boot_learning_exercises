package com.cemcelik.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cemcelik.controller.IRestCarController;
import com.cemcelik.controller.RestBaseController;
import com.cemcelik.controller.RootEntity;
import com.cemcelik.dto.DtoCar;
import com.cemcelik.dto.DtoCarIU;
import com.cemcelik.service.ICarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/Car")
public class RestCarControllerImpl extends RestBaseController implements IRestCarController {
	
	private ICarService carService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
		return ok(carService.saveCar(dtoCarIU));
	}

}
