package com.cemcelik.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoAddress;
import com.cemcelik.dto.DtoGallerist;
import com.cemcelik.dto.DtoGalleristIU;
import com.cemcelik.exception.BaseException;
import com.cemcelik.exception.ErrorMessage;
import com.cemcelik.exception.MessageType;
import com.cemcelik.model.Address;
import com.cemcelik.model.Gallerist;
import com.cemcelik.repository.AddressRepository;
import com.cemcelik.repository.GalleristRepository;
import com.cemcelik.service.IGalleristService;

@Service
public class GalleristService implements IGalleristService {
	
	@Autowired
	private GalleristRepository galleristRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {
		Optional<Address> optionalAddress = addressRepository.findById(dtoGalleristIU.getAddressId());
		if (optionalAddress.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristIU.getAddressId().toString()));
		}
		Gallerist gallerist = new Gallerist();
		gallerist.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoGalleristIU, gallerist);
		gallerist.setAddress(optionalAddress.get());
		return gallerist;
	}

	@Override
	public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {
		Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGalleristIU));
		DtoGallerist dtoGallerist = new DtoGallerist();
		BeanUtils.copyProperties(savedGallerist, dtoGallerist);
		DtoAddress dtoAddress = new DtoAddress();
		BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);
		dtoGallerist.setAddress(dtoAddress);
		return dtoGallerist;
	}

}
