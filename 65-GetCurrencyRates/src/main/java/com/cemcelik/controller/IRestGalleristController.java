package com.cemcelik.controller;

import com.cemcelik.dto.DtoGallerist;
import com.cemcelik.dto.DtoGalleristIU;

public interface IRestGalleristController {
	
	public RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);

}
