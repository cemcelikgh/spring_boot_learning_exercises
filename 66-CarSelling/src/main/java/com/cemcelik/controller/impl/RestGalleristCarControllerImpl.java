package com.cemcelik.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cemcelik.controller.IRestGalleristCarController;
import com.cemcelik.controller.RestBaseController;
import com.cemcelik.controller.RootEntity;
import com.cemcelik.dto.DtoGalleristCar;
import com.cemcelik.dto.DtoGalleristCarIU;
import com.cemcelik.service.IGalleristCarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/gallerist-car")
public class RestGalleristCarControllerImpl extends RestBaseController implements IRestGalleristCarController {
	
	@Autowired
	private IGalleristCarService galleristCarService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoGalleristCar> saveGalleristCar(@Valid @RequestBody DtoGalleristCarIU dtoGalleristCarIU) {
		return ok(galleristCarService.saveDtoGalleristCar(dtoGalleristCarIU));
	}

}
