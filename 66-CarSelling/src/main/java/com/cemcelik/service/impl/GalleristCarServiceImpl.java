package com.cemcelik.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoAddress;
import com.cemcelik.dto.DtoCar;
import com.cemcelik.dto.DtoGallerist;
import com.cemcelik.dto.DtoGalleristCar;
import com.cemcelik.dto.DtoGalleristCarIU;
import com.cemcelik.exception.BaseException;
import com.cemcelik.exception.ErrorMessage;
import com.cemcelik.exception.MessageType;
import com.cemcelik.model.Car;
import com.cemcelik.model.Gallerist;
import com.cemcelik.model.GalleristCar;
import com.cemcelik.repository.CarRepository;
import com.cemcelik.repository.GalleristCarRepository;
import com.cemcelik.repository.GalleristRepository;
import com.cemcelik.service.IGalleristCarService;

@Service
public class GalleristCarServiceImpl implements IGalleristCarService {
	
	@Autowired
	private GalleristCarRepository galleristCarRepository;
	
	@Autowired
	private GalleristRepository galleristRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	private GalleristCar createGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
		Optional<Gallerist> optionalGallerist = galleristRepository.findById(dtoGalleristCarIU.getGalleristId());
		if (optionalGallerist.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristCarIU.getGalleristId().toString()));
		}
		Optional<Car> optionalCar = carRepository.findById(dtoGalleristCarIU.getCarId());
		if (optionalCar.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristCarIU.getCarId().toString()));
		}
		GalleristCar galleristCar = new GalleristCar();
		galleristCar.setCreateTime(new Date());
		galleristCar.setGallerist(optionalGallerist.get());
		galleristCar.setCar(optionalCar.get());
		return galleristCar;
	}

	@Override
	public DtoGalleristCar saveDtoGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
		GalleristCar savedGalleristCar = galleristCarRepository.save(createGalleristCar(dtoGalleristCarIU));
		DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
		BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoGalleristCar);
		DtoGallerist dtoGallerist = new DtoGallerist();
		BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
		DtoAddress dtoAddress = new DtoAddress();
		BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(), dtoAddress);
		DtoCar dtoCar = new DtoCar();
		BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);
		dtoGallerist.setAddress(dtoAddress);
		dtoGalleristCar.setGallerist(dtoGallerist);
		dtoGalleristCar.setCar(dtoCar);
		return dtoGalleristCar;
	}

}
