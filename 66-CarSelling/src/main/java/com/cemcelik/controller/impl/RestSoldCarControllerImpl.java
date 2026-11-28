package com.cemcelik.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cemcelik.controller.IRestSoldCarController;
import com.cemcelik.controller.RestBaseController;
import com.cemcelik.controller.RootEntity;
import com.cemcelik.dto.DtoSoldCar;
import com.cemcelik.dto.DtoSoldCarIU;
import com.cemcelik.service.ISoldCarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/saled-car")
public class RestSoldCarControllerImpl extends RestBaseController implements IRestSoldCarController {
	
	@Autowired
	private ISoldCarService soldCarService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoSoldCar> buyCar(@Valid @RequestBody DtoSoldCarIU dtoSoldCarIU) {
		return ok(soldCarService.buyCar(dtoSoldCarIU));
	}

}
