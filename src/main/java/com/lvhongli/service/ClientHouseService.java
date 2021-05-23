package com.lvhongli.service;

import com.lvhongli.model.HouseArea;
import com.lvhongli.model.Rental;
import com.lvhongli.model.RoomConfig;
import com.lvhongli.model.SupportAddress;
import com.lvhongli.pojo.RoomConfigEnum;

import java.util.List;

public interface ClientHouseService {

    List<Rental> rentalAll();

    List<SupportAddress> findRegions(String belongTo);

    List<HouseArea> findAreas();

    List<RoomConfig> findRoomConfigByType(RoomConfigEnum type);
}
