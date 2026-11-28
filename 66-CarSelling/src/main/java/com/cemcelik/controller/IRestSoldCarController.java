package com.cemcelik.controller;

import com.cemcelik.dto.DtoSoldCar;
import com.cemcelik.dto.DtoSoldCarIU;

public interface IRestSoldCarController {
	
	public RootEntity<DtoSoldCar> buyCar(DtoSoldCarIU dtoSoldCarIU);

}
