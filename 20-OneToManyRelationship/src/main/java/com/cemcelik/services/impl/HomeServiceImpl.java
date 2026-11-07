package com.cemcelik.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoHome;
import com.cemcelik.dto.DtoRoom;
import com.cemcelik.entities.Home;
import com.cemcelik.entities.Room;
import com.cemcelik.repository.HomeRepository;
import com.cemcelik.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService {

	@Autowired
	private HomeRepository homeRepository;

	@Override
	public DtoHome findHomeById(Long id) {
		Optional<Home> optional = homeRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Home homeFromDb = optional.get();
		List<Room> roomsFromDb = optional.get().getRoom();
		DtoHome dtoHome = new DtoHome();
		BeanUtils.copyProperties(homeFromDb, dtoHome);
		if (roomsFromDb != null && !roomsFromDb.isEmpty()) {
			for (Room room : roomsFromDb) {
				DtoRoom dtoRoom = new DtoRoom();
				BeanUtils.copyProperties(room, dtoRoom);
				dtoHome.getRooms().add(dtoRoom);
			}
		}
		return dtoHome;
	}

}
